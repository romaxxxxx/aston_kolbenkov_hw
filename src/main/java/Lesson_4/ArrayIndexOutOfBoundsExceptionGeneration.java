package Lesson_4;

public class ArrayIndexOutOfBoundsExceptionGeneration {
    public static void main(String[] args) {
        int[] arr = new int[2];
        for(int i = 0;i<arr.length+1;i++){
            System.out.println(arr[i]);
        }
    }
}
