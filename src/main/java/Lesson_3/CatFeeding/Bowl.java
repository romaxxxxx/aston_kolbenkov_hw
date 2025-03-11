package Lesson_3.CatFeeding;

class Bowl {
    private static int foodVolume;

    public static int getFoodVolume() {
        return foodVolume;
    }

    public static void addFood(int foodVolume) {
        Bowl.foodVolume += foodVolume;
    }

    public static void degressFoodVolume(Cat cat) {
        if (foodVolume >= cat.getFoodAmountSatiety())
            Bowl.foodVolume -= cat.getFoodAmountSatiety();
    }
}