package me.plepis.accenture.bootcamp.day_three;

public class Task1 {

    private Integer[][] grid;

    private static final int tableSize = 12; // free to change

    private static Task1 instance;

    public static Task1 getInstance() {
        instance = instance == null ? new Task1() : instance;
        return instance;
    }

    private Task1() {
    }

    // actual code
    public void run() {

        this.grid = new Integer[tableSize + 1][tableSize + 1]; // need wrapper for generics

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) {
                    grid[row][col] = null;
                } else if (row == 0) {
                    grid[row][col] = col;
                } else if (col == 0) {
                    grid[row][col] = row;
                } else {
                    grid[row][col] = row * col;
                }

            }
        }
    }

}