package com.ohgiraffers.section02.superkeyword;

public class Computer extends Product{

    private int cpu;
    private int ram;

    public Computer() {
        super();
        System.out.println("Computer 기본 생성자 호출...");
    }

    public Computer(String code, String name, int price, int cpu, int ram) {
        super(code, name, price);       // super()에 인자를 전달하면 부모의 매개변수 있는 생성자를 호출
        this.cpu = cpu;
        this.ram = ram;
        System.out.println("Computer 클래스의 부모 필드도 초기화하는 생성자 호출...");
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String getInfomation() {

        // super.getInfomation() 부모가 만들어주는 문자열을 먼저 가져온다.
        // super를 생략하게 되면 this.가 자동 추가되어 재귀 호출이 일어난다.
        String parentInfo = super.getInfomation();

        // 자식 클래스 필드 정보를 덧붙여 완전한 정보를 만든다.
        String computerInfo = ", Computer [cpu= " + cpu + ", ram= " + ram + "]";

        return parentInfo + computerInfo;
    }

}
