package me.plepis.accenture;

import java.util.Arrays;

public class Interview {

    static int sumTwoGreatest(int i, int j, int k) {
        if (i <= j && i <= k) { // i smallest
            return j + k;
        } else if (j <= i && j <= k) { // j smallest
            return i + k;
        } else { // k smallest
            return i + j;
        }
    }

// avg O(n^2)
// first loop moves largest element to arr.size-1
// second loop moves second largest element to arr.size-2
        static int[] bubbleSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) { // i must stop at arr.size - 1 otherwise arr[i+1] throws IndexOutOfBoundsEx
                for (int j = 0; j < arr.length - 1; j++) { // I think theres a cleaner way of doing this but its bubble sort so its already bad
                    if (arr[j + 1] < arr[j]) {
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arr;
        }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{9, 1, 2, 7, 6, 3})));

    }
}
