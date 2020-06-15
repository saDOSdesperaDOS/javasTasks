package com.javarush.task.task19.task1908;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.stream.IntStream;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();


    }

    public static class TestString {

        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
