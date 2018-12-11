package com.javarush.task.task17.task1711;

/* 
Comparable
*/

/**
 @author by Mike Blokhin
 Требования:
 V1.	Класс Beach должен содержать три поля: String name, float distance, int quality.
 V2.	Класс Beach должен реализовывать интерфейс Comparable<Beach>.
 3.	Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
 V4.	Все методы класса Beach, кроме метода main, должны быть синхронизированы.
 **/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b1 = new Beach("beach1", 3.5055488f, 18);
        Beach b2 = new Beach("beach2", 1.5055488f, 58);
        b1.compareTo(b2);


    }

    @Override
    public synchronized int compareTo(Beach o) {
        int dif = 0;
        int r = 0;
        dif = (int) (this.getDistance()*this.getQuality()/2 - o.getDistance()*o.getQuality()/2);
        if (dif != 0) {
            r = dif > 0 ? 1 : -1;
        }
        if (r == 1) System.out.print(r + " ,First " + dif);
        else System.out.print(r +" ,Two " + dif);
        return r  ;


    }



}
