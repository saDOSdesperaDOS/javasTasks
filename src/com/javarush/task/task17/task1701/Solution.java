package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/**
 @author: Mike Blokhin
 Требования:
 V1.	Класс Solution должен содержать public static класс NoteThread.
 V2.	Класс NoteThread должен быть нитью.
 V3.	В методе run класса NoteThread должен быть цикл.
 4.	Метод run класса NoteThread должен 1000 раз вызывать метод addNote c параметром (getName() + "-Note" + index).
 5.	Метод run класса NoteThread должен 1000 раз вызывать Thread.sleep() c параметром (1).
 6.	Метод run класса NoteThread должен 1000 раз вызывать метод removeNote c параметром (getName()).
 **/


public class Solution {
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Thread {
        Note note = new Note();
        @Override
        public void run() {
            for (int index = 0; index < 1000; index++) {

                try {
                    note.addNote(getName() + "-Note" + index);
                    Thread.sleep(1);
                    note.removeNote(getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
