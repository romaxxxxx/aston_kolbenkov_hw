package Lesson_3;

class Bowl {
    private static int foodVolume;

    public static int getFoodVolume() {
        return foodVolume;
    }

    public static void addFood(int foodVolume) {
        Bowl.foodVolume = foodVolume;
    }

    public static void degressFoodVolume(Cat cat) {
        Bowl.foodVolume -= cat.getFoodAmountSatiety();
    }
}