package me.plepis.portfolio.math.pi_digits;

public class DigitsOfPi {

    double calculatePiFirst(int iterations){
        double sum = 0;
        for(int i=0; i < iterations; i++){
            double factor = i % 2 == 0 ? 1 : -1;
            sum += factor/(2*i + 1);
        }
        return 4*sum;
    }
    double calculatePiSecond(int iterations){
        double sum = 0;
        for(int i=1; i < iterations; i++){
            sum += 1.0/(i*i);
        }
        return Math.sqrt(6*sum);
    }

    static void print(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {

        DigitsOfPi dop = new DigitsOfPi();
        print(dop.calculatePiFirst(10000));
        print(dop.calculatePiSecond(10000));

    }
}
