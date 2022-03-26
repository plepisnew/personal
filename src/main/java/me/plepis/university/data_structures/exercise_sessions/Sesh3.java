package me.plepis.university.data_structures.exercise_sessions;

import java.util.Arrays;
import java.util.Random;

public class Sesh3 {

    public void printDuplicates(int[] a, int[] b){

        int indexA = 0;
        int indexB = 0;
        int steps = 0;
        while(steps <= 2*a.length){
            if(a[indexA] == b[indexB]){
                System.out.println(a[indexA]);
                if(indexA != a.length-1){
                    indexA++;
                }
                if(indexB != b.length-1){
                    indexB++;
                }
            }else if(b[indexB] > a[indexA]){
                if(indexA != a.length-1){
                    indexA++;
                }
            }else{
                if(indexB != b.length-1){
                    indexB++;
                }
            }
            if(indexA == a.length-1 && indexB == b.length-1){
                break;
            }
            steps++;
        }
    }

    public static void main(String[] args) {

        Sesh3 foo = new Sesh3();

        int[] a = getRandomArrayOfSize(30, 30);
        int[] b = getRandomArrayOfSize(30, 30);
        sortAndPrintArrays(a, b);
        foo.printDuplicates(a, b);

    }

    private static Random random = new Random();

    public static void sortAndPrintArrays(int[]... arrays){
        for(int[] array: arrays){
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void printArrays(int[]... arrays){
        for(int[] array: arrays){
            System.out.println(Arrays.toString(array));
        }
    }

    public static int[] getRandomArrayOfSize(int size, int range){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(range);
        }
        return arr;
    }
}
