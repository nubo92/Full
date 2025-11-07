package com.ohgiraffers.section02.userexception.exception;

public class NotEnoughMoneyExcrption extends Exception{

    /* 사용자 정의 예외 클래스를 만들기 위해서는 Exception클래스를 상속 받으면 된다. */

    // 기본 생성자
    public NotEnoughMoneyExcrption() {}

    // 예외 발생 시 전당할 메시지를 부모(Exception)에 넘겨주는 생성자
    public NotEnoughMoneyExcrption(String message) {
        super(message);
    }
}
