package com.ohgiraffers.section03.math;
import java.util.Random;

public class Application1 {
    public static void main(String[] args) {

        /* java.lang.math
        * 수학에서 자주 사용하는 상수들과 함수들을 미리 구현해놓은 클래스로, 모든 메소드는 static 메소드이다.
        * java.lang 패키지에 속해 있어 별도의 import가 필요 없다.
        * */

        // 절대값 구하기 : abs()
        System.out.println("절대값 : " + Math.abs(-7));

        // 최소값/최대값 구하기 min(), max()
        System.out.println("최소값 : " + Math.min(10, 20));
        System.out.println("최대값 : " + Math.max(10, 20));

        // 원주율 PI (미리 정의된 상수)
        System.out.println("파이값: " + Math.PI);

        //
        System.out.println("기본 난수 발생 : " + Math.random());      // 0.0 이상 1.0 미만의 실수 반환

        /* 공식: (int) (Math.random() * (구하려는 난구의 개수)) + (구하려는 난수의 최대값) */

        // 0 ~ 9 까지의 난수 발생
        int random1 = (int)(Math.random() * 10);        // 0.0 ~ 9.999,,, 를 int로 바꾸면 0 ~ 9
        System.out.println(random1);

        // 1 ~ 10 까지의 난수 발생
        int random2 = (int)(Math.random() * 10) + 1;
        System.out.println(random2);

        // 10 ~ 15 까지의 난수 발생
        int random3 = (int)(Math.random() * 6) + 10;
        System.out.println(random3);

        /* java.util.Random 클래스를 활용한 난수 발생 */

        // 1. Random 객체 생성
        Random random = new Random();

        // 0 ~ 9 까지의 난수 발생
        // nextInt(int cound): 0 부터 dound-1 까지의 정수 난수를 반환
        int randomNumber1 = random.nextInt(10);
        System.out.println(randomNumber1);

        // 20 ~ 40 까지의 난수 발생 (개수는 40 - 20 + 1 = 26개)
        int randomNumber2 = random.nextInt(26) + 20;
        System.out.println(randomNumber2);
    }
}
