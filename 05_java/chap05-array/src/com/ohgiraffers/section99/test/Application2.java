package com.ohgiraffers.section99.test;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[4];


        for(int i = 0; i < numbers.length; i++){
           int num = (int)(Math.random() * 10);

            boolean check = false;

            for( int j = 0; j < i; j++){

                if(numbers[j] == num) {
                    check = true;
                    break;
                }
            }
            if(check){
                i--;
            }else{
                numbers[i] = num;
            }
        }
        System.out.println(Arrays.toString(numbers));

        int life = 10;

        while(life > 0){
            System.out.println(life + "회 남으셨습니다.");
            System.out.print("4자리 숫자를 입력하세요 :");

            int score = sc.nextInt();
            if(score < 1000 || score > 9999) {
                System.out.println("4자리의 정수를 입력해야 합니다.");
                System.out.println();
                continue;
            }

            int[] userNumbers = new int[4];

            for(int i = 3; i >= 0; i--) {
                userNumbers[i] = score % 10;
                score = score / 10;
            }
            System.out.println(Arrays.toString(userNumbers));

            int strike = 0;
            int ball = 0;

            for(int i = 0; i < 4; i++) {
                if(numbers[i] == userNumbers[i]) {
                    strike++;
                }
            }

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(i != j && numbers[i] == userNumbers[j]
                            && numbers[i] != userNumbers[i]
                            && numbers[j] != userNumbers[j]) {
                        ball++;
                    }
                }
            }

            if(strike == 4) {
                System.out.println("정답입니다.");
                break;
            } else {
                System.out.println("아쉽네요 " + strike + "S " + ball + "B 입니다.");
                System.out.println();
                life--;
            }
        }
        if(life == 0) {
            System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
        }
    }
}
