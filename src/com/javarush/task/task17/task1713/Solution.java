package com.javarush.task.task17.task1713;

/* 
Синхронизированные методы
*/
/**
 @author by Mike Blokhin
 Требования:
 V1.	В method0, если необходимо, используй synchronized.
 V2.	В method1, если необходимо, используй synchronized.
 V3.	В method2, если необходимо, используй synchronized.
 V4.	В method3, если необходимо, используй synchronized.
 V5.	В method4, если необходимо, используй synchronized.
 V6.	В method5, если необходимо, используй synchronized.
 V7.	В method6, если необходимо, используй synchronized.
 V8.	В method7, если необходимо, используй synchronized.
 **/

public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        Double d = method3();
    }

    protected void method1(String param1) {
        Solution solution = new Solution();
        solution.method0();
    }

    public void method2(int param1) {
        param1++;
    }

    synchronized double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {
        return "" + param2;
    }

    public static void main(String[] args) {

    }

}
