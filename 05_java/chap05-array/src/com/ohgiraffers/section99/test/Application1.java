package com.ohgiraffers.section99.test;

import java.util.Arrays;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 입력하세요 : ");
        int num = sc.nextInt();

        if (num % 2 == 0 || num <= 0){
            System.out.println("양수 혹은 홀수만 입력해야 합니다.");
        }
        else {
            int[] numbers = new int[num];
            for(int i = 1; i <= (num/2+1); i++){

                for(int j = i-1; j <= num-i; j++ ){

                    numbers[j] = i;

                }
            }
            System.out.println(Arrays.toString(numbers));
        }
    }
}
