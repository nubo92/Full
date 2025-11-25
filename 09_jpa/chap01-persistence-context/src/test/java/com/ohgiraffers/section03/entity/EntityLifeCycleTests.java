package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityLifeCycleTests {

    private EntityLifeCycle lifeCycle;
    @BeforeEach
    void setUp() {
        this.lifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testTransient(int menuCode) {
        // when
        // 영속성 컨텍스트에서 관리되는 영속 상태의 객체(entityManager가 find로 찾아온 객체)
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        EntityManager entityManager = lifeCycle.getManagerInstance();

        // then
        assertNotEquals(foundMenu, newMenu);
        assertTrue(entityManager.contains(foundMenu));
        assertFalse(entityManager.contains(newMenu));
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedOtherEntityManager(int menuCode) {

        // when
        // findMenuByMenuCode 메소드를 호출했을 때 entity매니저가 새로 만들어지기 때문에 영속성 컨텍스트가 두개 만들어 진 것과 같다.
        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCode);

        //then
        assertNotEquals(menu1, menu2);

    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedSmaeEntityManager(int menuCode) {

        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        // when
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);

        //then
        assertEquals(menu1, menu2);
    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // detach : 특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하지 않는 상태)로 만든다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        // 영속성 컨텍스트의 상태를 DB로 내보낸다. commit하지 않는 상태이므로 rollback 가능하다.
        entityManager.flush();

        // then
        assertNotEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());

    }

    @DisplayName("준영속화 detach 후 다시 영속화(merge)")
    @ParameterizedTest
    @CsvSource({"11, 1000"})
    void testDetachAndMerge(int menuCode, int menuPrice) {

        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        entityManager.merge(foundMenu);
        entityManager.flush();
        // then
        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();

    }

    @DisplayName("detach 후 merge한 데이터 update테스트")
    @ParameterizedTest
    @CsvSource({"11, 하양 민트초코죽"})
    void stestMergeUpdate(int menuCode, String menuName) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);

        // when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);

        entityManager.merge(foundMenu);

        // then
        assertEquals(menuName, refoundMenu.getMenuName());
    }

    @DisplayName("detach후 merge한 데이터 save 테스트")
    @Test
    void restMergerSave() {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 20);
        entityManager.detach(foundMenu);

        // when
        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");
        foundMenu.setMenuCode(999);     // 존재하지 핞는 코드값으로 변경
        entityManager.merge(foundMenu);
        entityTransaction.commit();

        // then
        assertEquals("치약맛 초코 아이스크림", entityManager.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClearPersistenceContext(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        // clear : 영속성 컨텍스트 초기화 -> 모든 엔티티를 준영속화(detach) 시킴
        entityManager.clear();

        // then
        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
        assertNotEquals(foundMenu, expectedMenu);
    }

    @DisplayName("준영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClosePersistenceContext(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        // close : 영속성 컨텍스트를 종료한다.
        entityManager.close();

        // then
        assertThrows(IllegalStateException.class, () -> entityManager.find(Menu.class, menuCode));
    }

    @DisplayName("영속성 엔티티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void testRemoveEntity(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        entityTransaction.begin();
        // remove : 엔티티를 영속성 컨텍스트 및 데이터베이스에서 삭제
        entityManager.remove(foundMenu);

        // flush() : 영속성 컨텍스트의 변경 내용을 데이터 베이스에 동기화
        // commit까지 해야 SB에 온전히 반영된다.
        entityManager.flush();

        // then
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        assertNull(refoundMenu);
        entityTransaction.rollback();

    }

}
