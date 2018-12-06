package com.javarush.task.task17.task1711;

/* 
Comparable
*/
/**
 @author by Mike Blokhin
 Требования:
 1.	Класс Beach должен содержать три поля: String name, float distance, int quality.
 2.	Класс Beach должен реализовывать интерфейс Comparable<Beach>.
 3.	Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
 4.	Все методы класса Beach, кроме метода main, должны быть синхронизированы.
 **/

public class Beach {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
}
