package com.javarush.task.task17.task1707;

/* 
МВФ
*/

/**
 @author Mike Blokhin
 Требования:
 V1.	Класс IMF должен содержать приватное статическое поле IMF imf.
 V2.	Класс IMF должен содержать приватный конструктор.
 V3.	Класс IMF должен содержать публичный статический метод IMF getFund().
 V4.	Метод getFund() должен содержать синхронизированный блок.
 V5.	Внутри синхронизированного блока должно быть проинициализировано поле imf.
 6.	Метод getFund() должен всегда возвращать один и тот же объект.
 **/

public class Solution {
    public static void main(String[] args) {
        IMF fund = IMF.getFund();
        IMF anotherFund = IMF.getFund();
        System.out.println(fund == anotherFund );
    }
}
