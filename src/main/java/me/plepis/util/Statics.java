package me.plepis.util;

import java.util.List;
import java.util.Scanner;

public class Statics {

    private static final String prompt = "\n>>> ";

    public static Scanner scanner = new Scanner(System.in);

    public static double truncate(double input, int digits){
        double power = Math.pow(10, digits);
        return Math.floor(power * input)/power;
    }

    public static<T> void printList(List<T> elements){
        for(T t: elements){
            System.out.println(t.toString());
        }
    }

    public static Integer promptInteger(String string){
        System.out.print(string + prompt);
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public static String promptString(String string){
        System.out.println(string + prompt);
        return scanner.nextLine();
    }

}
