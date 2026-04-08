package p03.LastDigitOfApowB;

public class LastDigitOfApowB {

    /**
     * Finds last digit of a^b where a and b are strings (can be huge).
     * Uses Cyclicity logic (pattern repeats every 4 powers max).
     */
    public static int getLastDigit(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        // If exponent is 0, any a^0 = 1
        if (lenB == 1 && b.charAt(0) == '0') return 1;

        // Last digit of base 'a'
        int lastDigitA = a.charAt(lenA - 1) - '0';

        // Pattern cycle lengths for digits 0-9
        int[] cycleLen = {1, 1, 4, 4, 2, 1, 1, 4, 4, 2};
        int cycle = cycleLen[lastDigitA];

        // Find b % cycle (Modular arithmetic on string)
        int expMod = 0;
        for (int i = 0; i < lenB; i++) {
            expMod = (expMod * 10 + (b.charAt(i) - '0')) % cycle;
        }

        // If remainder is 0, it means it's the last position in the cycle
        if (expMod == 0) expMod = cycle;

        return (int) Math.pow(lastDigitA, expMod) % 10;
    }

    public static void main(String[] args) {
        System.out.println(getLastDigit("3", "10")); // 3^10 = ...9 -> 9
        System.out.println(getLastDigit("6", "2"));  // 6^2 = 36 -> 6
    }
}