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
  V5.	Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
  6.	Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
  7.	Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
  **/

public class Solution {


    public static List<Thread> threads = new ArrayList<>(5);

    static {
         ThreadOfFirstType threadOfFirstType = null;
         threadOfFirstType.setType("ThreadOfFirstType");
         ThreadOfSecondType threadOfSecondType = null;
         threadOfSecondType.setType("ThreadOfSecondType");
         ThreadOfThirdType threadOfThirdType = null;
         threadOfThirdType.setType("ThreadOfThirdType");
         ThreadOfFourthType threadOfFourthType = null;
         threadOfFourthType.setType("ThreadOfFourthType");
         ThreadOfFifthType threadOfFifthType = null;
         threadOfFifthType.setType("ThreadOfFifthType");

    }
// 1
    public class ThreadOfFirstType extends Thread {

        //fields
        private String type;

        //methods

        public void setType(String type) { this.type = type;}

        public String getType() {
            return type;
        }
        @Override
        public void run() {
          if(currentThread().isInterrupted()) currentThread().start();
        }
    }

// 2
    public class ThreadOfSecondType extends Thread {

        //fields
        private String type;

        //methods

        public void setType(String type) { this.type = type;}

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
// 3
     public class ThreadOfThirdType extends Thread {
         //fields
         private String type;

         //methods

         public void setType(String type) { this.type = type;}

         public String getType() {
             return type;
         }

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
    public class ThreadOfFourthType extends Thread implements Message{
         //fields
         private String type;

         //methods

         public void setType(String type) { this.type = type;}

         public String getType() {
             return type;
         }

         @Override
         public void showWarning() {

         }

         @Override
         public void run() {

         }
    }
// 5
    public class ThreadOfFifthType extends Thread {
         //fields
         private String type;

         //methods

         public void setType(String type) { this.type = type;}

         public String getType() {
             return type;
         }

         @Override
         public void run() {

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