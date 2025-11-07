package com.ohgiraffers.section06.singleton;

public class EagerSington {

    /* 클래스가 초기화 되는 시점에 인스턴스를 생성한다. */
    private static EagerSington eager = new EagerSington();

    /*  싱글톤 패턴은 생정자 호출을 통해 외부에서 ㅣㄴ스턴스 생성하는 것을 제한 */

    private EagerSington() {}

    /* public 인터페이스로 인스턴스를 반환하도록 한다. */
    public static EagerSington getInstance() {
        return eager;
    }
}
