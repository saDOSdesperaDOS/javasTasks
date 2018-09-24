package com.javarush.task.task17.task1708;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки для всех
*/
/**
 Требования:
 V1.	Класс Note должен содержать метод addNote(int index, String note).
 V2.	Класс Note должен содержать метод removeNote(int index).
 V3.	Класс Note должен содержать публичное поле List<String> notes.
 V4.	Поле List<String> notes не должно находится в локальном кэше.
 **/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public volatile List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }
}
