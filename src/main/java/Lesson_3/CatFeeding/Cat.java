package Lesson_3.CatFeeding;

class Cat extends Animal implements eatableFromBowl {
    private static int catCount = 0;
    private final int foodAmountSatiety;
    private boolean satiety = false;

    public Cat(String catName, int foodAmountSatiety) {
        super(catName, 0, 200);
        this.foodAmountSatiety = foodAmountSatiety;
        catCount++;
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void eatFromBowl() {
        if (Bowl.getFoodVolume() > this.foodAmountSatiety) {
            Bowl.degressFoodVolume(this);
            this.satiety = true;
        }
    }

    public int getFoodAmountSatiety() {
        return foodAmountSatiety;
    }

    public void catSatietyInfo() {
        if (satiety) {
            System.out.printf("Кот %s сегодня сытый\n", super.name);
        } else {
            System.out.printf("Кот %s сегодня голодный\n", super.name);
        }
    }

    public static void catCountInfo() {
        System.out.printf("Всего создано котов: %d\n", catCount);
    }
}