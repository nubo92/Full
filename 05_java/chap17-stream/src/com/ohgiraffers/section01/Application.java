package com.ohgiraffers.section01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        // 테스트용 데이터 리스트
        List<String> names = Arrays.asList("홍길동","유관순", "이순신", "신사임당", "장보고", "강감찬", "이성계");

        // 기존 방식 : for-each문을 사용한 외부 반복
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("================================");
        // [ 스트림 방식 ] forEach를 사용한 내부 반복
        names.stream().forEach(name -> System.out.println(name));

        /* 스트림 파이프라인 조립하기 */
        /*
        * 요구사항 : 이름이 4글자인 사람만 찾아서, "🍓신사임당🍓" 과 같은 형태로 변환하여 출력하라
        * */
        for (String name : names) {
            if(name.length() == 4) {
                String decoratedName = "🍓" + name + "🍓";
                System.out.println(decoratedName);
            }
        }
        System.out.println("=================================");

        names.stream()
                .filter(name -> name.length() == 3)
                .map(name -> "🍓" + name + "🍓")
                . forEach(decoratedName -> System.out.println(decoratedName));

        /* 스트임 결과물 만들기 : collect */
        /*
        * 요구사항 : 성이 '이'씨인 사람들을 찾아서, 알파벳 순서로 정렬한 후, 새로운 List로 만들어라
        * */
        List<String> leeFamily = names.stream()
                .filter(name -> name.startsWith("이"))
                .sorted()       // 가나다 순으로 정렬
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());      // 최종 결과물들을 새로운 List로 수집

        System.out.println("이씨 가문 사람들 : " +leeFamily);

        // 1. count() : 조건에 맞는 요소의 개수 세기
        long leeCount = names.stream()
                .filter(name -> name.startsWith("이"))
                .count();       // 스트림에 남은 요소의 개수를 반환
        System.out.println(leeCount);

        // 2. anyMatch() : 조건에 맞는 요소가 하나라도 있는지 확인
        boolean hasJang = names.stream()
                .anyMatch(name -> name.equals("장"));        // 하나라도 조건을 만족하면 true
        System.out.println(hasJang);

        // 3. allMatch() 모든 요소가 조건을 만족하는지 확인
        boolean isAllThreeLetters = names.stream()
                .allMatch(name -> name.length() == 3);      // 모든 요소가 조건을 만족하면 true
        System.out.println(isAllThreeLetters);

    }
}
