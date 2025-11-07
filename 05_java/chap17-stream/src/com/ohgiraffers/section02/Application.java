package com.ohgiraffers.section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<OnlineCourse> courses = Arrays.asList(
                new OnlineCourse("Java의 정석", "Programming", 120, false),
                new OnlineCourse("Spring 완전 끝내기", "Programming", 300, false),
                new OnlineCourse("JPA 끝징내기", "Programming", 240, false),
                new OnlineCourse("j포토샵 마스터", "Design", 90, true),
                new OnlineCourse("일러스트레이터 시작하기", "Design", 110, true),
                new OnlineCourse("SQL 첫걸음", "Datebase", 80, true),
                new OnlineCourse("데이터베이스 모델링", "Datebase", 150, false)
        );

        /* Programming 카테고리 중 수강 시간 200분 초과인 강의 제목 추출하기 */
        for(OnlineCourse c : courses) {
            if ("Programming".equals(c.getCategory()) && c.getDuration() > 200) {
                System.out.println(c.getCategory());
            }
        }

        courses.stream()
                .filter(c -> "Programming".equals(c.getCategory()))
                .filter(c -> c.getDuration() > 200)
                .map(OnlineCourse::getTitle)
                .forEach(System.out::println);

        /* 중간 연산 */
        // sorted
        courses.stream()
                .filter(OnlineCourse::isFree)
                // Comparator람다식으로 구현! 오름차순 정렬
                .sorted((c1, c2) -> c1.getDuration() - c2.getDuration())
                .forEach(System.out::println);

        // distinct : 중복 제거하기
        courses.stream()
                .map(OnlineCourse::getCategory)
                .distinct()
                .forEach(System.out::println);

        /* 최종 연산 */

        // collect
        List<OnlineCourse> designCourses = courses.stream()
                .filter(c -> "Design".equals(c.getCategory()))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(designCourses);

        // 간단한 통계 구현
        // count() : 스트임에 남아있는 요소 개수 확인
        // sum() : 남은 요소의 합계
        // average() : 남은 요소의 평균
        int totalDurationOfFreeCourses = courses.stream()
                .filter(OnlineCourse::isFree)
                .mapToInt(OnlineCourse::getDuration)        // mapToInt : IntStream으로 변환(sum() 수행 가능)
                .sum();
        System.out.println(totalDurationOfFreeCourses + "분");

        /* groupingBy */
        // 모든 강의를 카테고리별로 분류해서 정리하기
        // collect에게 groupungBy를 할건데 기준은 '카테고리'야 라고 알려주면
        // 스트림이 알라서 MAP<카테고리, 해당 강의 리스트> 형태로 분류해줌
        Map<String, List<OnlineCourse>> courseByCategory = courses.stream()
                .collect(Collectors.groupingBy(OnlineCourse::getCategory));

        // Map 출력
        courseByCategory.forEach((category, courseList) -> {
            System.out.println("[" + category + "]");
            courseList.forEach(c -> System.out.println(" - " + c.getTitle()));
        });

    }
}
