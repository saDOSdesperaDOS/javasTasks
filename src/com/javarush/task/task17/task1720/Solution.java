package com.javarush.task.task17.task1720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

/* 
CRUD

CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id, заменяет все его данные на null
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990

Требования:
1.V	Класс Solution должен содержать public static поле allPeople типа List<Person>.
2.V	Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3.	При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4.	При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5.	При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6.	При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static SimpleDateFormat date = new SimpleDateFormat("dd/dd/dddd", Locale.ENGLISH);
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
          String input = reader.readLine();
          char ch = input.charAt(1);
            System.out.println(date());
        } catch (IOException e) {
              e.printStackTrace();
        }

    }

    public boolean regExpValidator(String email) {

        Pattern p = Pattern.compile("/A[a-zA-Z]{1}/s[a-zA-Z]{3,10}/s[a-zA-Z]{1}/s" + date +"/Z");
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
