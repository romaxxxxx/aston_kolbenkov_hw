package Lesson_3;

abstract class Animal {
    private static int animalCount;
    private String name;
    private int runningDistanceCapacity;
    private int swimmingDistanceCapacity;

    public Animal(String name, int runningDistanceCapacity, int swimmingDistanceCapacity) {
        animalCount++;
        this.name = name;
        this.runningDistanceCapacity = runningDistanceCapacity;
        this.swimmingDistanceCapacity = swimmingDistanceCapacity;
    }

    void run(int obstacleLength) {
        System.out.printf("%s пробежал %d метров/n", name, obstacleLength);
    }

    void swim(int obstacleLength) {
        System.out.printf("%s пробежал %d метров/n", name, obstacleLength);
    }

    public String getName() {
        return name;
    }
}