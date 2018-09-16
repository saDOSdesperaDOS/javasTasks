package com.javarush.task.task16.task1633;


/**
 @author: Mike Blokhin
 Требования:
 V1.	Метод main должен создавать нить с параметрами: commonThread и "Нить 1".
 V2.	Метод main должен создавать нить с параметрами: commonThread и "Нить 2".
 V3.	Метод main должен запускать две созданные нити типа Thread.
 V4.	Метод main должен прерывать две созданные нити типа Thread.
 5.	Программа с помощью метода uncaughtException класса OurUncaughtExceptionHandler должна вывести 2 сообщения.
 6.	Метод uncaughtException класса OurUncaughtExceptionHandler явно не вызывать.
 7.	Вывод программы должен содержать строки: "Нить 1: My exception message" и "Нить 2: My exception message".
 **/
public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();//своя реализация метода  public void uncaughtException(Thread t, Throwable e)

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");//поток авт-и стартует при создании, т.к это указанно в кострукторе
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();//поток засыпает на 3000 мл.сек, т.к это указанно в методе run()
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {
            //setUncaughtExceptionHandler(handler);//установили оьработку неотлавлиемого исключения
            setDefaultUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");

            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());//переопределили метод uncaughtException(Thread t, Throwable e)
        }
    }
}
