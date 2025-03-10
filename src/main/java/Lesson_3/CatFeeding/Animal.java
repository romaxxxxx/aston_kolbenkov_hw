package Lesson_3.CatFeeding;

abstract class Animal {
    private static int animalCount = 0;
    protected String name;
    private static int swimmingDistanceCapacity;
    private static int runningDistanceCapacity;

    public Animal(String name, int swimmingDistanceCapacity, int runningDistanceCapacity) {
        this.name = name;
        Animal.swimmingDistanceCapacity = swimmingDistanceCapacity;
        Animal.runningDistanceCapacity = runningDistanceCapacity;
        animalCount++;
    }

    void run(int obstacleLength) {
        if (obstacleLength < runningDistanceCapacity) {
            System.out.printf("%s пробежал %d метров\n", name, obstacleLength);
        } else {
            System.out.println("Далеко бежать");
        }
    }

    void swim(int obstacleLength) {
        if (obstacleLength < swimmingDistanceCapacity) {
            System.out.printf("%s проплыл %d метров\n", name, obstacleLength);
        } else {
            System.out.println("Далеко плыть");
        }
    }

    public String getName() {
        return name;
    }

    public static void AnimalCountInfo() {
        System.out.printf("Всего создано блохастых: %d\n", animalCount);
    }
}