package com.ohgiraffer.section02.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {
        /*
        * LinkedHashSet
        * - '중복 불가'의 특징을 그대로 유지한다.
        * - 추가적으로 요소가 입력된 순서를 기억하여 순서를 유지하는 특징을 가진다.
        * */

        Set<String> hest = new HashSet<>();
        hest.add("java");
        hest.add("html");
        hest.add("css");
        hest.add("java");

        Set<String> lhset = new LinkedHashSet<>();
        lhset.add("java");
        lhset.add("html");
        lhset.add("css");
        lhset.add("java");      // 중복은 여전히 불가

        System.out.println("HashSet 결과 : " + hest);
        System.out.println("LinkedHashSet 결과 : " + lhset);      // 입력 순서를 유지함


    }
}
