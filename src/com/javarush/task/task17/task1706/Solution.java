package com.javarush.task.task17.task1706;

/* 
Синхронизированный президент
*/
/**
 @author: Mike Blokhin
 Требования:
 V1.	Класс OurPresident должен содержать приватную статическое поле OurPresident president.
 V2.	Класс OurPresident должен содержать публичный статический метод OurPresident getOurPresident().
 V3.	Класс OurPresident должен содержать приватный конструктор.
 V4.	Класс OurPresident должен содержать статический блок.
 V5.	Внутри статического блока класса OurPresident должен быть синхронизированный блок.
 V6.	Внутри синхронизированного блока должно быть проинициализировано поле president.
 **/


public class Solution {
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident );
    }
}
