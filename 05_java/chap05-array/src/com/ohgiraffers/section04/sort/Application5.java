package com.ohgiraffers.section04.sort;

import java.util.Arrays;
import java.util.Random;

public class Application5 {
    public static void main(String[] args) {

        /* 배열과 정렬을 응용하여 중복 없는 로또 번호를 생성해보자! */

        // 1. 6개의 숫자를 담을 배영 새성
        int[] lotto = new int[6];

        // 2. 중복되지 않는 난수를 셍성하여 배열에 담기
        for (int i = 0; i < lotto.length; i++) {
            int num = (int) (Math.random() * 45) + 1;

            boolean chack = false;

            for( int j = 0; j < i; j++){

                if(lotto[j] == num) {
                    chack = true;
                    break;
                }
            }
            if(chack){
                i--;
            }else{
                lotto[i] = num;
            }


        }
        // 3. 정렬하여 출력
        System.out.println("정렬 전 : " + Arrays.toString(lotto));
        Arrays.sort(lotto);
        System.out.println("정렬 후 : " + Arrays.toString(lotto));

    }
}
