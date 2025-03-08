package Lesson_3.CatFeeding;

abstract class Animal {
    private static int animalCount = 0;
    private String name;

    public Animal(String name) {
        animalCount++;
        this.name = name;
    }

    void run(int obstacleLength) {
        System.out.printf("%s пробежал %d метров\n", name, obstacleLength);
    }

    void swim(int obstacleLength) {
        System.out.printf("%s проплыл %d метров\n", name, obstacleLength);
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}