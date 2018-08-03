package com.javarush.task.task16.task1630;

/*Требования:
+1.	Статический блок класса Solution должен считывать с консоли имена двух файлов и сохранять их в переменные firstFileName и secondFileName.
+2.	Объяви в классе Solution public static класс ReadFileThread.
+3.	Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
+4.	Класс ReadFileThread должен быть унаследован от подходящего класса.
+5.	Метод run класса ReadFileThread должен считывать строки из файла, установленного методом setFileName. А метод getFileContent, этого же класса, должен возвращать вычитанный контент. Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
6+.	Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
7.	Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface  {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fullFileName;
        List<String> content = new ArrayList<>();

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            StringBuffer strContent = new StringBuffer();
            for (String s:content) {
                strContent.append(s).append(" ");
            }
            //return this.toString();
            return strContent.toString();
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                if (reader.ready()) {
                    String str = reader.readLine();
                    content.add(str);
                }
                reader.close();
            } catch (FileNotFoundException e) {
                    System.out.println("File "+fullFileName+" not found");
            } catch (IOException e){
                    System.out.println("File " + fullFileName + " can't read");
            }
        }
    }
}

/*Требования:
+1.	Статический блок класса Solution должен считывать с консоли имена двух файлов и сохранять их в переменные firstFileName и secondFileName.
+2.	Объяви в классе Solution public static класс ReadFileThread.
+3.	Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
+4.	Класс ReadFileThread должен быть унаследован от подходящего класса.
+5.	Метод run класса ReadFileThread должен считывать строки из файла, установленного методом setFileName. А метод getFileContent, этого же класса, должен возвращать вычитанный контент. Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
6.	Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
7.	Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.*/