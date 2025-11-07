package com.ohgiraffers.section02.extend;

public class FarmManager {

    // RabbitFarm<?> : Rabbit의 자손이라면 어떤 타입이든 상관없는 RabbitFarm을 매개변수로 받는다.
    public void manageAnyFarm(RabbitFarm<?> farm) {
        System.out.print("어떤 토끼 농장이든 관리 가능해요 : ");
        farm.getAnimal().cry();
    }

    public void manageBunnyFarm(RabbitFarm<? extends Bunny> farm) {
        System.out.print("버니 혹은 더 특별한 버니 농장만 관리해요.:");
        farm.getAnimal().cry();
    }

    public void manageRabbitOrBunnyFarm(RabbitFarm<? super Bunny> fram) {
        System.out.print("바니 혹은 일반 토끼 농장에 새로운 바니를 넣어요:");
        farm.getAnimal().cry();
    }
 }
