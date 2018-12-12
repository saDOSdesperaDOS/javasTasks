package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Аптека
*/

/**
 @author by Mike Blokhin
 Требования:
 V1.	Класс Solution должен содержать public static поле drugsController типа DrugsController.
 V2.	Класс Solution должен содержать public static поле isStopped типа boolean.
 V3.	Класс Solution должен содержать private static void метод waitAMoment(), который должен ждать 100 мс.
 V4.	Класс Apteka должен реализовывать интерфейс Runnable.
 V5.	Нить Apteka должна работать пока isStopped = false.
 V6.	Нить Apteka должна использовать drugsController для закупки случайного лекарства (getRandomDrug) в количестве (getRandomCount).
 V7.	Нить Apteka должна ждать 300мс + "между закупками", используя метод waitAMoment().
 V8.	Класс Person должен реализовывать интерфейс Runnable.
 V9.	Нить Person должна работать пока isStopped = false.
 V10.	Нить Person должна использовать drugsController для продажи случайного лекарства (getRandomDrug) в количестве (getRandomCount).
 V11.	Нить Person должна ждать 100мс + "между закупками", используя метод waitAMoment().
 V12.	Методы класса DrugsController должны быть synchronized.
 **/

public class Solution {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements  Runnable {

        @Override
        public void run() {
           while(!isStopped){
               drugsController.buy(getRandomDrug(),getRandomCount());
               waitAMoment();
               waitAMoment();
               waitAMoment();
           }
        }
    }

    public static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
                drugsController.sell(getRandomDrug(), getRandomCount());
                waitAMoment();
            }
        }
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
