package com.ohgiraffers.section01;

public class literal_and_variable {
    public static void main(String[] args) {

        int num1 = 20;
        int num2 = 30;

        System.out.println("더하기 결과:" + (num1 + num2));
        System.out.println("빼기 결과:" + (num1 - num2));
        System.out.println("곱하기 결과:" + (num1 * num2));
        System.out.println("나누기 목:" + (num1 / num2));
        System.out.println("나누기한 나머지:" + (num1 % num2));

        double num3 = 12.5;
        double num4 = 36.4;

        double num5 = num3 * num4;
        double num6 = (num3 + num4) * 2;
        System.out.println("면적:" + num5);
        System.out.println("둘레:" +num6);

        char ch1 = 'a';
        int num7 = (int)ch1;
        System.out.println("문자 a의 unicode:" + num7);

        double kor = 80.5;
        double mat = 50.6;
        double eng = 70.8;

        int total = (int)(kor+mat+eng);
        int mein = (int)(kor+mat+eng) / 3;

        System.out.println("총점:" + total);
        System.out.println("평균:" + mein);



    }
}
