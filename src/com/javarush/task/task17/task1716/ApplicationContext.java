package com.javarush.task.task17.task1716;

import java.util.HashMap;
import java.util.Map;

/* 
ApplicationContext
*/
/**
 author by Mike Blokhin

 Требования:
 V1.	Класс ApplicationContext должен быть абстрактным.
 V2.	Класс ApplicationContext должен содержать private поле container типа Map<String, GenericsBean>.
 V3.	В getByName(String name), если необходимо, используй synchronized.
 V4.	В removeByName(String name), если необходимо, используй synchronized.
 **/

public abstract class ApplicationContext<GenericsBean extends Bean> {

    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>

    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public synchronized GenericsBean getByName(String name) {
          return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}
