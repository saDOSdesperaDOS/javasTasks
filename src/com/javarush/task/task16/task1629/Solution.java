package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут

        /*t1.printResult();
        t2.printResult();*/
        t1.start();
        t1.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {

        private static int c = 3;
        private List<String> result = new ArrayList();

        @Override
        public void run() {
            while (c>0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String str = reader.readLine();
                    result.add(str);
                    c--;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Thread.currentThread().interrupt();

        }

        public void printResult() {

            System.out.println(result);

        }
    }
}
