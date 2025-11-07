package com.ohgiraffers.section02.superkeyword;

public class Application {
    public static void main(String[] args) {

        Product product = new Product();
        System.out.println(product.getInfomation());

        Product product2 = new Product("S-0123", "갤럭시", 2300000);
        System.out.println(product2.getInfomation());

        Computer computer = new Computer("X-9123", "갤럭시", 4300000, 512, 12);
        System.out.println(computer.getInfomation());


        SmartPhone smartPhone = new SmartPhone("SN-9786", "갤럭시",  1550000 , "samsung");
        System.out.println(smartPhone.getInfomation());
    }
}
