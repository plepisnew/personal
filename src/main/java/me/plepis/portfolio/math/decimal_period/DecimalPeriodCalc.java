package me.plepis.portfolio.math.decimal_period;

import me.plepis.util.Runnable;
import me.plepis.util.Statics;

import java.util.ArrayList;
import java.util.List;

public class DecimalPeriodCalc implements Runnable {

    private static DecimalPeriodCalc instance;

    private int OGdividend;
    private int divisor;
    private int quotientInteger;
    private String quotientDecimal;
    private String decimalPrefix;
    private String period;

    private List<Integer> totients;


    private DecimalPeriodCalc(){
    }

    public static DecimalPeriodCalc getInstance(){
        if(instance == null){
            instance = new DecimalPeriodCalc();
        }
        return instance;
    }

    private void calculatePeriod(){
        totients = new ArrayList<>();
        StringBuilder quotient = new StringBuilder();
        StringBuilder quotientDec = new StringBuilder();
        StringBuilder periodString = new StringBuilder();

        int dividend = OGdividend;
        this.quotientInteger = continuousSubtraction(dividend, divisor);
        quotient.append(quotientInteger).append(".");
        totients.add(dividend);
        dividend -= quotientInteger*divisor;
        dividend *= 10;

        do{
            int decimalDigit = continuousSubtraction(dividend, divisor);
            quotient.append(decimalDigit);
            quotientDec.append(decimalDigit);
            totients.add(dividend);
            dividend -= decimalDigit*divisor;
            dividend *= 10;
        }while(!totients.contains(dividend));

        StringBuilder prefixString = new StringBuilder();
        for(int i=0; i < totients.indexOf(dividend); i++){
            prefixString.append(continuousSubtraction(totients.get(i), divisor));
        }
        for(int i=totients.indexOf(dividend); i<totients.size(); i++){
            periodString.append(continuousSubtraction(totients.get(i), divisor));
        }

        this.quotientDecimal = String.valueOf(quotientDec);
        this.period = String.valueOf(periodString);
        this.decimalPrefix = String.valueOf(prefixString);


    }

    private int continuousSubtraction(int pDividend, int pDivisor){
        int res = 0;
        while(pDividend >= pDivisor){
            pDividend -= pDivisor;
            res++;
        }
        return res;
    }

    private void readInputs(){
        this.OGdividend = Statics.promptInteger("Enter Dividend:");
        this.divisor = Statics.promptInteger("Enter Divisor:");
    }

    private void printResults(){
        String prefix = decimalPrefix.equals(" ") ? "" : decimalPrefix;
        System.out.print(OGdividend + " / " + divisor + " = " + quotientInteger + "." + prefix + "(" + period + ") = ");
        String suffix = "pppp";
        while(suffix.contains("p")){
            suffix = suffix.replace("p", String.valueOf(period));
        }
        System.out.println(quotientInteger + "." + prefix + suffix);
        System.out.println("With period " + period + " and period length " + String.valueOf(period).length());
    }


    @Override
    public void run() {
        readInputs();
        calculatePeriod();
        printResults();
    }
}
