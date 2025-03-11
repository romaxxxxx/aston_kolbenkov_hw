package Lesson_3.CatFeeding;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int foodVolume = 61;

    public static void main(String[] args) {
        Bowl.addFood(foodVolume);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька", 20);
        cats[1] = new Cat("Матроскин", 40);
        cats[2] = new Cat("Тотошка", 1);
        cats[3] = new Cat("Платошка", 10);

        for (Cat cat : cats) {
            cat.eatFromBowl();
            cat.catSatietyInfo();
        }

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Шарик"));
        animals.add(new Cat("Матроскин", 3));

        for(Animal animal : animals){
            animal.swim(9);
            animal.run(100);
            animal.swim(11);
            animal.run(501);
        }

        Animal.AnimalCountInfo();
        Cat.catCountInfo();
        Dog.DogCountInfo();
    }
}