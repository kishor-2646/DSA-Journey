package p01_Pow;

import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of x and n");
        double x = sc.nextDouble();
        long n = sc.nextLong();

        double res = myPow(x,n);

        System.out.println(res);


    }

    public static double myPow(double x, long n) {
        long power = n;

        if(power < 0)
        {

            power = -power;
            return 1.0 / calculate(x, power); // for precision problems  : calculate the positive power first, then take its reciprocal at the end. This can reduce floating-point rounding errors for inputs
        }

        return calculate(x, power);
    }

    public static double calculate(double x, long n)
    {
        if(n == 0)
            return 1.0;

        double half = calculate(x, n / 2);

        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}
