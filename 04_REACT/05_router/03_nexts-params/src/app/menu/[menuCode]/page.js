'use client'
import { getMenuByMenuCode } from "@/api/MenuAPI";
import { useParams } from "next/navigation"
import { useEffect, useState } from "react";

export default function MenuDetail() {

    const {menuCode} = useParams();     // pathVariable 값을 가져올 수 있다.  /menu/[menuCode]
    console.log(menuCode);

    const [menu, setMenu] = useState();

    useEffect(() => {
        setMenu(getMenuByMenuCode(menuCode));
    }, []);

    return (
        menu &&
        <>
            <h1>{menu.menuName }상세 페이지!</h1>
            <h3>메뉴 가격: {menu.menuPrice}</h3>
            <h3>메뉴 종류: {menu.categoryName}</h3>
            <h3>메뉴 설명: {menu.detail.description}</h3>
            <img src={menu.detail.image} style={{maxWidth: 500}}/>
        </>
    )
}