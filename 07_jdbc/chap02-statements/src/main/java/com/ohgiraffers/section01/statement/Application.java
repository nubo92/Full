package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection();

        // 쿼리를 운반하고 결과를 반환하는 객체
        Statement stmt = null;
        // select결과집합을 받아 올 인터페이스
        ResultSet rest = null;

        try {
            stmt = con.createStatement();
            rest = stmt.executeQuery("SELECT EMP_id, EMP_NAME FROM EMPLOYEE");

            while(rest.next()) {
                /* next() : ResultSet 커서 위치를 내리면서 행이 다음 존재하면 true, 존재하지 않으면 false 반환
                * getXXX(컬럼명) : 커서가 가리키는 행의 컬럼을 XXX 데이터 타입으로 반환한다,
                * */
                System.out.println(rest.getString("EMP_ID") + ", " + rest.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 맨 마지막에 열렸던 애부터 순서대로 닫아준다.
            close(rest);
            close(stmt);
            close(con);
        }


    }
}
