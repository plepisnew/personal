package me.plepis.portfolio.math.square_problem;

import me.plepis.util.Runnable;
import static me.plepis.util.Statics.truncate;

import java.util.Scanner;

public class DeltaXCalc implements Runnable {

    private final Scanner scanner;
    private int x;
    private int K;
    private double dx;
    private static final int truncateDigits = 5;
    private static DeltaXCalc instance;

    private DeltaXCalc(){
        this.scanner = new Scanner(System.in);
    }

    public static DeltaXCalc getInstance(){
        if(instance == null){
            instance = new DeltaXCalc();
        }
        return instance;
    }

    void readInputs(){
        this.x = readInteger("Enter side length x of a Square:");
        this.K = readInteger("Enter relative area change K:");
    }

    private int readInteger(String prompt){
        System.out.print(prompt + "\n>>> ");
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    void calculateChange(){
        double inverseSqrt = 1/Math.sqrt(this.K);
        this.dx = 0.5*this.x*(1 - inverseSqrt);
    }



    void outputResult(){
        double firstArea = truncate(x*x, 5);
        double newArea = truncate((x-2*dx)*(x-2*dx), truncateDigits);
        double tdx = truncate(dx, truncateDigits);
        System.out.println("Square side length " + x + " with area " + firstArea);
        System.out.println("To yield " + K + " times smaller area we need dx = " + tdx);
        System.out.println("Giving square with side length " + (x-2*tdx) + " and area " + newArea);
        System.out.println("Ratio of areas K = " + firstArea + " / " + newArea + " = " + firstArea/newArea);
        System.out.println("dK = | " + K + " - " + this.K + " | = " + Math.abs(K - firstArea/newArea));
    }

    public void run(){
        DeltaXCalc calc = init();
        calc.readInputs();
        calc.calculateChange();
        calc.outputResult();
    }

    private DeltaXCalc init(){
        System.out.println("\nGiven a Square with side length x, find dx so that the area decreases K times");
        System.out.println("GetChange: (x, K) -> dx");
        return getInstance();
    }

}
