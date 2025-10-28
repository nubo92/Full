package com.greedy.level01.basic;


public class Calculator {
    public void checkMethod() {
        System.out.println("메소드 호출 확인");
    }
    public int sum() {
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            sum += i;
        }
        return sum;
    }
    public void checkMaxNumber(int a, int b) {
        System.out.println("두 수중 최대 값은 : " + Math.max(a, b));
    }
    public int sumTwoNumber(int a, int b) {
        int sum1 = a + b;
        return sum1;
    }
    public int minusTwoNumber (int a, int b) {
        int minus1 = a - b;
        return minus1;
    }
}
