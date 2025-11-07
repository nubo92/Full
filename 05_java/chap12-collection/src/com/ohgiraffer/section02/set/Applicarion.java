package com.ohgiraffer.section02.set;

import java.sql.Struct;
import java.util.*;

public class Applicarion {
    public static void main(String[] args) {

        /* Set 인터페이스를 구현한 컬렉션 클래스의 특징
        * 1. 요소의 저장 순서를 유지하지 않는다. (입력 순서오 출력 순서가 다를 수 있다.)
        * 2. 같은 요소의 중복 저장을 허용하지 않는다. (똑같은 값은 하나만 저장된다.)
        * */

        List<String> alist = new ArrayList<>();
        alist.add("java");
        alist.add("mysql");
        alist.add("jdbc");
        alist.add("java");      // 중복 허용

        Set<String> hest = new HashSet<>();
        hest.add("java");
        hest.add("html");
        hest.add("css");
        hest.add("java");       // 중복 허용하지 않음

        System.out.println("ArrayList : " + alist);
        System.out.println("HashSet : " + hest);

        /* Set은 순서(인덱스)가 없기 때문에, List처럼get(index)를 사용하요 요소룰 꺼낼 수 없다.
        * 따라서 전체 요소를 대상으로 연속 처리를 하고 싶을 때는 다음 방법을 사용한다.
        * */

        // 1. toArray() : Set을 배열로 바꿔서 반복
        Object[] arr = hest.toArray();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 2. iterator() : 반복자를 사용하여 연속 처리 ( 가장 표중적인 방법)
        // Iterator는 어떤 컬렉션이든 동일한 방식으로 순화할 수 있게 해주는 '반복자'객체
        Iterator<String> iter = hest.iterator();
        while(iter.hasNext()) {      // 다은에 꺼낼 요소가 있다면 true
            System.out.println(iter.next());        // 다음 요소를 꺼냄

        }
    }
}
