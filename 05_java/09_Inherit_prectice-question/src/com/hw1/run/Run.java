package com.hw1.run;

import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Person;
import com.hw1.model.dto.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Student[] studentArray = new Student[3];

        studentArray[0] = new Student("홍길동", 20, 178.2, 70.0,1, "정보시스템공학과");
        studentArray[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        studentArray[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");


        for (Student student : studentArray) {
            System.out.println(student.information());
        }


        // Employee employee = new Employee();
        Employee[]  employeeArray = new Employee[10];
        Scanner sc = new Scanner(System.in);
        int count = 0;



        while (true) {
            if(count >= employeeArray.length) {
                System.out.println("정원(10명)을 초과했습니다. 프로그램을 종료합니다.");
                break;
            }
                System.out.println("========= 사원 관리 프로그램 ========");
                employeeArray[count] = new Employee();

                System.out.print("사원 이름 : ");
                employeeArray[count].setName(sc.next());
                System.out.print("사원 나이 : ");
                employeeArray[count].setAge(sc.nextInt());
                System.out.print("사원 신장 : ");
                employeeArray[count].setHeight(sc.nextDouble());
                System.out.print("사원 몸무게 : ");
                employeeArray[count].setWeight(sc.nextDouble());
                System.out.print("사원 급여 : ");
                employeeArray[count].setSalary(sc.nextInt());
                System.out.print("사원 부서 : ");
                employeeArray[count].setDept(sc.next());
                count++;

                System.out.print("계속 추가 하시겠습니까(Y / N) : ");
                char yn = sc.next().charAt(0);

                if (yn == 'y' || yn == 'Y') {
                    System.out.println(yn + " 계속 입력");
                    if (count == 2) {
                        for ( int i = 0; i < count; i++) {
                            System.out.println(employeeArray[i].information());

                        }
                    }
                    continue;

                } else if  (yn == 'n' || yn == 'N') {
                    System.out.println("프로그램을 종료합니다. 등록된 사원입니다.");
                    for ( int i = 0; i < count; i++) {
                        System.out.println(employeeArray[i].information());
                    }
                    break;
                }



        }

    }
}
