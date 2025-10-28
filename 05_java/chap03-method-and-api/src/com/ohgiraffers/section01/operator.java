package com.ohgiraffers.section01;

public class operator {
    public static void main(String[] args) {


        int num1 = 20;
        int num2 = 10;

        String st1 = (num1 > num2)? "두 수 중 큰수는"+ num1 +"입니다" : "두 수 중 큰수는" + num2 + "입니다";
        System.out.println(st1);

        int num3 = 70;
        int num4 = 50;

        System.out.println((num3 >= 60)? "합격입니다~~!!!" : "아쉽지만 불합격입니다....");
        System.out.println((num4 >= 60)? "합격입니다~~!!!" : "아쉽지만 불합격입니다....");

        int num5 = 10;
        int num6 = 9;

        System.out.println((num5 % 2 == 0)? "입력하신 수는 짝수입니다.": "입력하신 수는 홀수입니다.");
        System.out.println((num6 % 2 == 0)? "입력하신 수는 짝수입니다.": "입력하신 수는 홀수입니다.");


        double num7 = 85.53;
        int num8 = (int)num7;

        String st2 = (num8 >= 90)? "A" : (num8 >= 80)? "B" : (num8 >= 70) ? "C" : (num8 >= 60)? "D" : "F";
        System.out.println("홍길동의 이번 점수등급은 " + st2 + "입니다");

        int num9 = 5;
        int num10 = 16;
        int num11 = 7;

        String st3 = ((num9 >= 1 && num9 <= 6) && (num10 >= 1 && num10 <= 15))?
                "배민 쿠폰" : ((num9 >= 7 && num9 <= 12) && (num10 >= 16 && num10 <= 31))?
                "스타벅스 커피" : "사탕";

        String st4 = ((num11 >= 1 && num11 <= 6) && (num10 >= 1 && num10 <= 15))?
                "배민 쿠폰" : ((num11 >= 7 && num11 <= 12) && (num10 >= 16 && num10 <= 31))?
                "스타벅스 커피" : "사탕";

        System.out.println("나의 선물은" + st4 + "입니다");
        System.out.println("나의 선물은" + st3 + "입니다");




    }
}
