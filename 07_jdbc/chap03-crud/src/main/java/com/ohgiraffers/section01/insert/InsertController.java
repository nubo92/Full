package com.ohgiraffers.section01.insert;

import java.sql.ResultSet;
import java.util.List;

public class InsertController {

    public int insertMenu(MenuDTO newMenu) {
        ResultSet rset = null;

        MenuDTO row = null;

        List<MenuDTO> menuList = null;

        int result = 0;

        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, menuCode);
        pstmt.setString(2, menuName);
        pstmt.setInt(3, menuPrice);
        pstmt.setInt(4, categoryCode);
        pstmt.setString(5, orderableStatus);







        return result;
    }
}
