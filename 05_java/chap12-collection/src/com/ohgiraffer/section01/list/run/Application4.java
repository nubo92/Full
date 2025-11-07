package com.ohgiraffer.section01.list.run;

import java.util.EmptyStackException;
import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {
        /* Stack
        * - 후입선출(LIFO) 방식의 자료구조이다.
        *
        * - 웹 브라우저의 '뒤로 가기' 기능
        * - 프로그램의 '실행 취소' 기능
        * - 재귀 알고리즘을 반복문으로 구현할 때
        * */
        Stack<Integer> integerStrak = new Stack<>();

        // stack에 값을 넣을 때는 push() 사용
        integerStrak.push(1);
        integerStrak.push(2);
        integerStrak.push(3);
        integerStrak.push(4);

        System.out.println(integerStrak);

        /*
        * peek() : 가장 꼭대기 요소를 '확인만'하고 제거하지는 않는다.
        * pop() : 가장 꼭대기 요소를 '꺼내고' 제거한다.
        * */

        System.out.println("peek() : " + integerStrak.peek());
        System.out.println(integerStrak);

        System.out.println("pop() : " + integerStrak.pop());
        System.out.println(integerStrak);


        try{
            integerStrak.pop();
            integerStrak.pop();
            integerStrak.pop();     // 이미 여기에서 stack이 다 비워짐
            integerStrak.pop();     // 에러 발생!!

        } catch (EmptyStackException e) {
            System.out.println("스택이 비어있습니다.");
        }

    }
}
