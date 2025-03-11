package Lesson_5.Phonebook;

import Lesson_5.Phonebook.Phonebook;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("вася", "123");
        phonebook.add("вася", "124");
        phonebook.add("петя", "125");
        phonebook.get("вася");
        phonebook.get("петя");
    }
}
