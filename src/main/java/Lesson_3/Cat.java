package Lesson_3;

class Cat extends Animal implements eatableFromBowl {
    private static final int RUNNING_DISTANCE_CAPACITY = 200;
    private static int catCount = 0;
    private final int foodAmountSatiety;
    private boolean satiety = false;

    public Cat(String catName, int foodAmountSatiety) {
        super(catName);
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

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}