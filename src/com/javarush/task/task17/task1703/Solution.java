package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
*/
/**
 @author: Mike Blokhin
 Требования:
 V1.	Метод addNote() должен добавлять записки в список notes.
 V2.	Метод removeNote() должен удалять записку из списка notes.
 V3.	В методе addNote() должен находиться synchronized блок.
 V4.	В методе removeNote() должен находиться synchronized блок.
 V5.	Synchronized блок в методе addNote() должен блокировать мьютекс notes.
 V6.	Synchronized блок в методе removeNote() должен блокировать мьютекс notes.
 V7.	В synchronized блоке метода addNote() должен находится вызов метода add у notes.
 V8.	В synchronized блоке метода removeNote() должен находится вызов метода remove у notes.
 9.	Все команды вывода на экран не должны находиться в блоке synchronized.
 **/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            synchronized (notes) {notes.add(index, note);}
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            String note = " ";
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            synchronized (notes) {
                note = notes.remove(index);
            }
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);

        }
    }

}
