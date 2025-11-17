package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {


        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매 여부를 입력 받기 (Scanner 이용) */
        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rset = null;

        Properties prop = new Properties();


        /* 2. MenuDTO 객체를 생성하여 입력받은 값으로 setting */

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("updateMenu2");

            Scanner sc = new Scanner(System.in);

            System.out.print("변경할 메뉴의 번호를 입력하세요 : ");
            int menuCode = sc.nextInt();

            System.out.print("변경하고 싶은 메뉴의 이름을 입력하세요 : ");
            sc.nextLine();
            String menuName = sc.nextLine();

            System.out.print("변경하고 싶은 메뉴의 가격을 입력하세요 : ");
            int menuPrice = sc.nextInt();

            System.out.print("변경하고 싶은 메뉴의 카테고리를 입력하세요 :");
            int categoryCode = sc.nextInt();

            System.out.print("변경하고 싶은 메뉴의 판매 여부를 입력하세요 :");
            String orderableStatus = sc.nextLine();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


        /* 3. InsertController의 insertMenu() 메소드 호출 */

        /* 4. Insert 걀과에 따라 성공이면 '메뉴 등록 성공!' 출력, 실패이면 '메뉴 등록 실패!' 출력 */
    }
}
