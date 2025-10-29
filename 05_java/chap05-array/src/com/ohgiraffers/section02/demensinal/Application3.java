package com.ohgiraffers.section02.demensinal;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        // 3명 학생의 국어, 영어, 수학 점수를 저장할 2차원 배열
        // 행(층) : 학생 3명
        // 열(방) : (국어, 영어, 수학)
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요 : ");
        int studentCount = sc.nextInt();

        System.out.print("과목 수를 입력하세요 : ");
        int subjectCount = sc.nextInt();

        int[][] iarr = new int[studentCount][subjectCount];

        for (int i = 0; i < iarr.length; i++) {
            System.out.println((i + 1) + "번 학생의 점수를 입력하세요: ");
            for(int j = 0; j < iarr[i].length; j++) {
                System.out.print(" " + (i + 1) + "번째 과목 점수 : ");

//                String[] str = {"국어", "영어", "수학"};
//                System.out.print((i + 1) + "번 학생의 " + str[j] + " 점수를 입력하세요 : ");

                iarr[i][j] = sc.nextInt();
            }
        }

        // 각 학생의 총점과 평균 계산 및 출력
        for(int i = 0; i < iarr.length; i++) {
            int sum = 0;
//            double avg = 0.00;
            for(int j = 0; j < iarr[i].length; j++) {
                sum += iarr[i][j];
//                avg = sum / iarr[i].length;
            }
            double avg = sum / iarr[i].length;

            System.out.println((i + 1) + "번 학생의 총점은 : " + sum + "점 입니다.");
            System.out.println((i + 1) + "번 학생의 평균은 : " + avg + "점 입니다.");
        }

        System.out.println();

        int[][] scores = {
                {80, 76, 85},
                {78, 60, 95},
                {90, 80, 68}
        };

        for(int i = 0; i < scores.length; i++) {        // i는 학생 번호
            int sum1 = 0;       // 총점 저장할 변수
            for(int j = 0; j < scores[i].length; j++) {
                sum1 += scores[i][j];       // 현재 학생의 j번째 과목 점수 누적
            }

            double avg1 = sum1 / scores[i].length;

            System.out.println((i + 1) + "번 학생의 총점 : " + sum1);
            System.out.println((i + 1) + "번 학생의 평균 : " + avg1);
        }



    }
}
