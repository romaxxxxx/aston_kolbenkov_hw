package Lesson_2;

public class Park {
    class Attraction {
        String name;
        String workingHours;
        Long cost;

        public Attraction(String name, String workingHours, Long cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public Long getCost() {
            return cost;
        }
    }

}