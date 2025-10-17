'use client'
import Link from "next/link";
import { usePathname } from "next/navigation";

export default function Navbar() {

    const pathname = usePathname();     // 현재 경로 가져오기

    const isActive = (path) => pathname === path;       // menu/1
    // const isActive = (path) => pathname.startsWith(path);     // menu/1 같은 하위 경로에도 적용시키려면...

    const activeStyle = {
        backgroundColor : 'yellow',
        color : 'red',
    }

    return (
        <>
            <div>
                <ul>
                    <li><Link href="/" style={isActive('/') ? activeStyle : undefined}>메인</Link></li>
                    <li><Link href="/menu" style={isActive('/menu') ? activeStyle : undefined}>메뉴</Link></li>
                    <li><Link href="/about" style={isActive('/about') ? activeStyle : undefined}>소개</Link></li>
                </ul>
            </div>
        </>
    )
}