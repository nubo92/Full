package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BidirectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // 메뉴 테이블에서 메뉴 코드를 찾아와줘
    public Menu findMenu(int menuCode) {
        return entityManager.find(Menu.class, menuCode);
    }

    // 카테고리 테이블에서 카테고리 코드를 찾아와줘
    public Category findCategory(int categoryCode) {
        return entityManager.find(Category.class, categoryCode);
    }


}
