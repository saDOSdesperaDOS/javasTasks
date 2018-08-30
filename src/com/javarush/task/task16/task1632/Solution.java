package com.javarush.task.task16.task1632;


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
  5.	Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
  6.	Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
  7.	Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
  **/

public class Solution {


    public static List<Thread> threads = new ArrayList<>(5);

    static {



    }

    interface TypeThread {
        String getType();
    }

    public class ThreadOfFirstType implements Runnable, TypeThread  {

        //fields
        private String type;

        //methods
        public void setType(String name) { this.type = name;}
        public String getType() {
            return type;
        }
        @Override
        public void run() {
          if(currentThread().isInterrupted()) currentThread().start();
        }
    }


    public class ThreadOfSecondType implements Runnable, TypeThread {

        //fields
        private String type;

        //methods
        public void setType(String name) { this.type = name;}
        public String getType() {
            return type;
        }
        @Override
        public void run() {
           try {
               currentThread().interrupt();
           }catch(Exception e) {
               System.out.println(new InterruptedException("Возникло исключение InterruptException"));
               e.printStackTrace();
           }
        }
    }


    public class ThreadsTypesFabric {

        public Polygon getThreadOfType() {
            Polygon th = null;
            ThreadOfFirstType thT1 = null;
            Thread th1 = null;
            if(th.getType().contains("first")) {
                thT1.setType(th.getType());
               // th1 = new Thread(thT1);//Thread of first type
            }

                return thT1;
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