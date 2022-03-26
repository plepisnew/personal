package me.plepis.accenture.bootcamp.day_three;

import java.util.Arrays;

public class Task2 {

    private static Task2 instance;

    public static Task2 getInstance() {
        instance = instance == null ? new Task2() : instance;
        return instance;
    }

    private Task2() {
    }

    public void run() {
        int[] nums;
        nums = new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * Integer.MAX_VALUE) + 1;
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

}