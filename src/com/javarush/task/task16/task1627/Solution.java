package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;
/**
 2. Реализуй логику метода run так, чтобы для каждого игрока:
 2.1. Через равные интервалы времени (1000ms / rating) выводились в консоль действия, описанные в steps.
 2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем сам текст. Пример: [Ivanov:Начало игры].
 2.3. Когда игрок выполнит все действия из steps, то он считается победителем. Выведите [getName() + ":победитель!"].
 2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными. Выведите для них [getName() + ":проиграл"].
 **/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;
        public static List<String> steps = new ArrayList<String>();
        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }
        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);
        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();
            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    /**Требования:
     1.	Метод run класса Gamer через равные интервалы времени (1000ms / rating) должен выводить в консоль фамилию игрока (метод getName()), потом двоеточие, а затем текст из OnlineGame.steps. Пример: [Ivanov:Начало игры].
     2.	Когда все игровые шаги будут выполнены, а победитель еще не найден, метод run должен установить флаг OnlineGame.isWinnerFound в true (сообщить остальным, что он победитель).
     3.	Если игрок стал победителем, его метод run должен вывести надпись [getName() + :победитель!]. Например: [Sidorov:победитель!].
     4.	Методы run всех игроков которые не стали победителями (были прерваны), должны вывести надписи [getName() + :проиграл]. Например: [Petrov:проиграл]
     5.	Метод run не должен кидать исключение при прерывании.**/

    public static class Gamer extends Thread  {
        private int rating;
        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }
        @Override
        public void run() {
            //Add your code here - добавь код тут
            /*for (int i = 0; i <= OnlineGame.steps.size() - 1 ; i++) {
                System.out.println(getName()+":"+OnlineGame.steps.get(i));
                try {
                    Thread.sleep(1000/rating);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
            if (!OnlineGame.isWinnerFound)
                System.out.println(getName() + ":победитель!");
                OnlineGame.isWinnerFound = true;*/

            try {
                for (String action : OnlineGame.steps) {
                    System.out.println(getName() + ":" + action);
                    Thread.sleep(1000 / rating);
                }

                if (!OnlineGame.isWinnerFound)
                    System.out.println(getName() + ":победитель!");
                OnlineGame.isWinnerFound = true;

            } catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл");
                return;
            }
        }
        }
    }

