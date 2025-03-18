package Lesson_5.Phonebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    public Map<String, Set<String>> phoneBook;

    public Phonebook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        Set<String> phoneSetForName = new HashSet<>();
        if (phoneBook.containsKey(name)) {
            phoneSetForName = phoneBook.get(name);
            phoneSetForName.add(phone);
            phoneBook.put(name, phoneSetForName);
        } else
            phoneSetForName.add(phone);
        phoneBook.put(name, phoneSetForName);
    }

    public void get(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println(phoneBook.get(name));
        } else {
            System.out.printf("Контакта \"%s\" нет в тел. книге", name);
        }
    }
}