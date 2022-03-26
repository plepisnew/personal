package me.plepis.portfolio.math.square_problem;

import me.plepis.util.Runnable;

import java.util.ArrayList;
import java.util.Scanner;

import static me.plepis.util.Statics.truncate;

public class RatioCalc implements Runnable {

    private int x; // side length of square
    private int dx; // side length decrement
    private final Scanner scanner;
    private static RatioCalc instance;
    private ArrayList<String> percentages;

    public static RatioCalc getInstance(){
        if(instance == null){
            instance = new RatioCalc();
        }
        return instance;
    }

    private RatioCalc(){
        this.scanner = new Scanner(System.in);
        this.percentages = new ArrayList<>();
    }

    private void readInputs(){
        this.x = readInteger("Enter side length x of a Square:");
        this.dx = readInteger("Enter size of decrement dx:");

    }

    private int readInteger(String prompt){
        System.out.print(prompt + "\n>>> ");
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private void decrementSquare(){
        int length = x;
        while(length > 0){
            double area = length*length;
            double newArea = (length-2*dx)*(length-2*dx);
            System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=->");
            System.out.println("Side Length: " + length + " with Area: " + area);
            System.out.println("New Side Length: " + (length-2*dx) + " with Area: " + newArea);
            System.out.println("dA = A(x) - A(x-dx) = " + area + " - " + newArea + " = " + (area-newArea));
            double percentage = truncate(((area-newArea)/(x*x))*100, 2);
            percentages.add(percentage + "%");
            System.out.println("dA/A = " + percentage + " %");
            length -= 2*dx;

        }
        System.out.println(percentages);
    }

    private void requestNumberOfPercentagesToSum(){
        int count = readInteger("How many decrement progresses would you like to sum?");
        double sum = 0;
        for(int i=0; i<count; i++){
            String parsed = percentages.get(i).substring(0, percentages.get(i).length()-1);
            double percent = Double.parseDouble(parsed);
            sum += percent;
        }
        System.out.println("First " + count + " decrements will cut " + sum + "% of the Initial Area");
    }

    private RatioCalc init(){
        System.out.println("\nGiven a Square with side length x, decrement it by dx and find cut area.");
        System.out.println("GetAreaRatio: (x, dx) -> r");
        return getInstance();
    }

    public void run(){
        RatioCalc calc = init();
        calc.readInputs();
        calc.decrementSquare();
        calc.requestNumberOfPercentagesToSum();

    }
}
