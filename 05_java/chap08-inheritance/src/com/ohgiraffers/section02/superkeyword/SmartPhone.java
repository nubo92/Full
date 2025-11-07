package com.ohgiraffers.section02.superkeyword;

// Product 클래스 상속 받는다.
public class SmartPhone extends Product{

    // 고유 필드를 하나 추가
    private  String brand;

    // 부모 필드 포함 모든 필드를 초기화하는 생성자
    public SmartPhone() {
        super();
        System.out.println("smartPhone 기본 생성자 호출...");
    }

    public SmartPhone(String code, String name, int price, String brand) {
        super(code, name, price);
        this.brand = brand;
        System.out.println("SmartPhone 초기화 생성자 호출...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // getInfomation() 메소드 오버라이딩

    @Override
    public String getInfomation() {
//        String parentInfo = super.getInfomation();
//        String smartPhone = ", SmartPhone [Brand = " + brand + "]";
//        return parentInfo + smartPhone;
        return super.getInfomation() + ", SmartPhone [Brand = " + brand + "]";
    }
}
