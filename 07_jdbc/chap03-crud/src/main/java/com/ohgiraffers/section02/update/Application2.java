package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴 번호 : ");
        int menuCode = sc.nextInt();
        System.out.print("변경할 메뉴의 이름 : ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("변경할 메뉴의 가격 : ");
        int menuPrice = sc.nextInt();

        MenuDTO changedMenu = new MenuDTO();
        changedMenu.setMenuCode(menuCode);
        changedMenu.setMenuName(menuName);
        changedMenu.setMemuPrice(menuPrice);

        UpdateController controller = new UpdateController();

        int result =



    }
}
