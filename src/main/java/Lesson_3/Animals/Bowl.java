package Lesson_3.Animals;

class Bowl {
    private static int foodVolume = 0;

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