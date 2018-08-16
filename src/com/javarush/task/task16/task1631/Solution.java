package com.javarush.task.task16.task1631;
/*Требования:
       + 1.	Создай в пакете common класс JpgReader, реализующий интерфейс ImageReader.
       +2.	Создай в пакете common класс PngReader, реализующий интерфейс ImageReader.
       + 3.	Создай в пакете common класс BmpReader, реализующий интерфейс ImageReader.
       + 4.	Создай публичный класс ImageReaderFactory.
       +5.	Добавь в класс ImageReaderFactory открытый статический метод getImageReader с параметром ImageTypes.
        6.	Метод getImageReader должен создавать и возвращать подходящий Reader.
        7.	Метод getImageReader должен кидать исключение IllegalArgumentException, если передан неправильный параметр.*/

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}
