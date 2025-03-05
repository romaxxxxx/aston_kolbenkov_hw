package Lesson_3;

abstract class Animal {
    static int animalCount;
    String name;
    int runningDistanceCapacity;
    int swimmingDistanceCapacity;

    public Animal(String name, int runningDistanceCapacity, int swimmingDistanceCapacity) {
        animalCount++;
        this.name = name;
        this.runningDistanceCapacity = runningDistanceCapacity;
        this.swimmingDistanceCapacity = swimmingDistanceCapacity;
    }

    void run(int obstacleLength) {
        System.out.printf("%s пробежал %d метров%n", name, obstacleLength);
    }

    void swim(int obstacleLength) {
        System.out.printf("%s пробежал %d метров%n", name, obstacleLength);
    }
}