package com.javarush.task.task17.task1718;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

/**
 @author by Mike Blokhin

 Требования:
 V1.	Класс Solution должен содержать public static поле allLines типа List<String>.
 V2.	Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
 V3.	Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
 V4.	Программа должна считывать c консоли имена двух файлов.
 V5.	Программа должна считывать построчно данные из первого файла в список allLines.
 V6.	Программа должна считывать построчно данные из второго файла в список forRemoveLines.
 V7.	Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
 V8.	Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
 V9.	Метод joinData должен вызываться в main.

**/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String nf1, nf2;
        String f1line = null;
        String f2line = null;
        BufferedReader bufferIn = new BufferedReader(new InputStreamReader(System.in));
        try {
                /*nf1 = bufferIn.readLine();
                nf2 = bufferIn.readLine();*/
            nf1 = "/home/snaek2/temp/fileFirst.txt";
            nf2 = "/home/snaek2/temp/fileSecond.txt";
            BufferedReader bufferInF1 = new BufferedReader(new FileReader(nf1));
            BufferedReader bufferInF2 = new BufferedReader(new FileReader(nf2));

            /*while (file1.ready()) {
                allLines.add(file1.readLine());
            }*/

            while ((f1line = bufferInF1.readLine()) != null) {
                allLines
                        .add(f1line);
            }
            while ((f2line = bufferInF2.readLine()) != null) {
                forRemoveLines
                        .add(f2line);
            }
            System.out.println(allLines.size());
            joinData();
            System.out.println(allLines.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
