package p04_GoodNumbers;

public class Solution {
    static int MOD = 1000000007;
    public static int countGoodNumbers(long n) {
        long evenCnt = (n + 1) / 2;
        long oddCnt = n / 2;

        long evenWays = power(5, evenCnt);
        long primeWays = power(4, oddCnt);

        return (int)((evenWays * primeWays) % MOD);
    }

    public static long power(long base, long expo)
    {
        if(expo == 0)
            return 1;

        long half = power(base, expo / 2);

        long result = (half * half) % MOD;

        if(expo % 2 == 1)
        {
            result = (base * result) % MOD;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(50));
    }

}
