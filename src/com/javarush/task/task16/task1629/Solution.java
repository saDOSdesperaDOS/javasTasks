package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    private static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {

        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.run();//t1 must using start();
        t1.join();//this work without join();
        t2.run();
        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {

        private List<String> result = new ArrayList<String>();
        private int c = 3;

        @Override
        public void run() {
            try {
                while (c > 0) {
                    String str = reader.readLine();
                    result.add(str);
                    c--;
                }
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                System.out.println("You have exception!");
                e.printStackTrace();
            }
        }//the end of run();

        public void printResult() {
            for (String str:result) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        @Override
        public String toString() {
            return result.toString();
        }

    }//the end of Read3Strings
}//the end of Solution
