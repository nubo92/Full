package com.ogiraffers.section.intro;

@FunctionalInterface        // 이 인터페이스는 메소드가 딱 ㅏ나만 있어야 해!!
// 함수형 인터페이스 : 메소드가 단 하나만 정의된 인터페이스
public interface Calculator {

    int sumTwoNumber(int a, int b);
}
