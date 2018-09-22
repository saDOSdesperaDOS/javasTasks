package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/* 
Сад-огород
*/
/**
 @author: Mike Blokhin
 Требования:
 1.	Класс Garden должен содержать метод public void addFruit(int index, String fruit).
 2.	Класс Garden должен содержать метод public void removeFruit(int index).
 3.	Класс Garden должен содержать метод public void addVegetable(int index, String vegetable).
 4.	Класс Garden должен содержать метод public void removeVegetable(int index).
 5.	Метод addFruit(int index, String fruit) должен добавлять параметр fruit в лист fruits на позицию index.
 6.	Метод removeFruit(int index) должен удалять из fruits элемент с индексом index.
 7.	Метод addVegetable(int index, String vegetable) должен добавлять параметр vegetable в лист vegetables на позицию index.
 8.	Метод removeVegetable(int index) должен удалять из vegetables элемент с индексом index.
 9.	Все методы класса Garden должны блокировать мьютекс this (быть синхронизированы).
 **/

public class Solution {


    public static void main(String[] args) {

    }

    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public void addFruit(int index, String fruit) {
           synchronized (this) {fruits.add(index, fruit);}
        }

        public void removeFruit(int index){
            synchronized (this) {fruits.remove(index);}
        }

        public void addVegetable(int index, String vegetable){
            synchronized (this) {vegetables.add(index, vegetable);}
        }

        public void removeVegetable(int index){
            synchronized (this) {vegetables.remove(index);}
        }

    }
}
