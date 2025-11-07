package com.ohgiraffers.section01.extend;

public class Application {
    public static void main(String[] args) {

        Car car = new Car();

        car.run();
        car.soundHorn();
        car.stop();
        car.soundHorn();


        // Car를 상속 박은 FireCar 만들기
        FireCar fireCar = new FireCar();

        fireCar.run();
        fireCar.soundHorn();
        fireCar.stop();
        fireCar.soundHorn();

        fireCar.sparyWater();

        RacingCar racingCar = new RacingCar();
        racingCar.run();
        racingCar.soundHorn();

    }
}
