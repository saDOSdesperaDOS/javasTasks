package com.javarush.task.task16.task1632;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Thread.currentThread;

/**
  @author: Mike Blokhin
  Требования:
  V1.	Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
  V2.	Нити из списка threads не должны стартовать автоматически.
  V3.	Нить 1 из списка threads должна бесконечно выполняться.
  V4.	Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
  V5.	Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
  V6.	Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
  V7.	Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
  **/

public class Solution {


    public static List<Thread> threads = new ArrayList<>(5);

    static {

         threads.add(new ThreadOfFirstType("threadOfFirstType"));
         threads.add(new ThreadOfSecondType("threadOfSecondType"));
         threads.add(new ThreadOfThirdType("threadOfThirdType"));
         threads.add(new ThreadOfFourthType("threadOfFourthType"));
         threads.add(new ThreadOfFifthType("threadOfFourthType"));
    }

    // 1
    public static class ThreadOfFirstType extends Thread {

        public ThreadOfFirstType(String type){super(type);}

        @Override
        public void run() {
          if(currentThread().isInterrupted()) currentThread().start();
        }
    }

    // 2
    public static class ThreadOfSecondType extends Thread {

    public ThreadOfSecondType(String type){super(type);}

        @Override
        public void run() {
           try {
               currentThread().interrupt();
           }catch(Exception e) {
               System.out.println(new InterruptedException("InterruptException"));
               e.printStackTrace();
           }
        }
    }

    // 3
     public static class ThreadOfThirdType extends Thread {

         public ThreadOfThirdType(String type){super(type);}

         @Override
         public void run() {
             try {
                 while (true) {
                     System.out.println("Ура");
                     Thread.sleep(500);
                 }
             } catch (InterruptedException e) {

             }
         }
    }

    // 4
    public static class ThreadOfFourthType extends Thread implements Message{

    private boolean die;

    public ThreadOfFourthType(String type){super(type);}

         @Override
         public void showWarning() {
            die = true;
         }

         @Override
         public void run() {
            while (die == false) {

            }
         }
    }

    // 5
    public static class ThreadOfFifthType extends Thread {

        private int inInt;

        public ThreadOfFifthType(String type){super(type);}

         @Override
         public void run() {
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             try {
                 String in = bufferedReader.readLine();
                 while(!in.equals("N")){
                     inInt =+ Integer.parseInt(in);
                 }
                 System.out.println(inInt);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    }


    public static void main(String[] args) {
        for (Thread s: threads) {
            System.out.println("start");
            s.start();
            System.out.println("finish");
        }
    }
}