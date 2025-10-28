package com.ohgiraffers.section01.conditional;

import java.util.Scanner;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        test.score();
        test.score2();
        test.score3();
        test.score4();

    }
    public void score() {

        Scanner sc = new Scanner(System.in);
        System.out.print("국어 점수를 입력하세요 : ");
        int kor = sc.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        int eng = sc.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        int mat = sc.nextInt();

        int mein = (kor + eng + mat) / 3;

        if (mein <= 60) {
            System.out.println("평규 점수 미달로 불합격입니다");
            if(kor <= 40 ) {
                System.out.println("국어 점수 미달로 불합격입니다.");
            }if(eng <= 40 ) {
                System.out.println("영어 점수 미달로 불합격입니다");
            }if(mat <= 40 ) {
                System.out.println("수학 점수 미달로 불합격입니다");
            }
        }else {
            System.out.println("합격입니다.");
        }
        System.out.println();
    }

    public void score2() {
        Scanner sc = new Scanner(System.in);

        System.out.print("월 금여 입력 : ");
        int monthly =  sc.nextInt();
        System.out.print("매출액 입력 : ");
        int salary =  sc.nextInt();
        double bonus = 0;
        int total = 0;

        if(salary >= 5000){
            bonus = 0.05;
            total = (int)(monthly + (salary * bonus));
        } else if (salary >= 3000) {
            bonus = 0.03;
            total = (int)(monthly + (salary * bonus));
        } else if (salary >= 1000) {
            bonus = 0.01;
            total = (int)(monthly + (salary * bonus));
        }else{
            bonus = 0.0;
            total = (int)(monthly + (salary * bonus));
        }
        System.out.println("===============");
        System.out.println("매출액 : " + salary);
        System.out.println("보너스율 : " + (bonus * 100) + "%");
        System.out.println("월 급여 : " + monthly);
        System.out.println("보너스 금액 : " + (int)(salary * bonus));
        System.out.println("===============");
        System.out.println("총 급여 : " + total);
        System.out.println();
    }

    public void score3() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        for(int i = 1; i <= num; i++){
            if(i % 2 == 0){
                System.out.print("박");
            }else{
                System.out.print("수");
            }
        }
        System.out.println();
    }

    public void score4() {
        Scanner sc = new Scanner(System.in);
        int num2 = (int)(Math.random() * 100) + 1;
        int num;
        int count = 0;

        do {
            System.out.print("정수를 입력하세요 : ");
            num = sc.nextInt();
            if(num > num2){
                System.out.println("입력하신 정수보다 작습니다.");
            } else if (num < num2) {
                System.out.println("입력하신 정수보다 큽니다.");
            }
            count++;
        } while(!(num == num2));
        System.out.println("정답입니다." + count + "회만에 정답을 맞추셨습니다.");
    }
}

