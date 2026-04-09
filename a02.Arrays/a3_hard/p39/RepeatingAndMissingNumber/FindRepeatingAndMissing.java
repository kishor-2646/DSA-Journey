package a3_arrays.p39.RepeatingAndMissingNumber;

public class FindRepeatingAndMissing {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Linear Search Count
    // For each number 1 to N, count its frequency.
    // If count == 2 → repeating; if count == 0 → missing.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int[] findBrute(int[] nums) {
        int n = nums.length;
        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) count++;
            }
            if (count == 2) repeating = i;
            else if (count == 0) missing = i;

            if (repeating != -1 && missing != -1) break;
        }

        return new int[]{repeating, missing};
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Hash Array (Frequency Map)
    // Use a hash array of size N+1 to track frequencies.
    // Scan hash array: freq==2 → repeating, freq==0 → missing.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int[] findBetter(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];

        for (int num : nums) hash[num]++;

        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1) break;
        }

        return new int[]{repeating, missing};
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal 1 – Math (Sum & Sum of Squares)
    // Sn  = n*(n+1)/2        → S  - Sn  = X - Y
    // S2n = n*(n+1)*(2n+1)/6 → S2 - S2n = X² - Y²
    // X + Y = (S2 - S2n) / (S - Sn)
    // Solve: X = ((X+Y) + (X-Y)) / 2, Y = X - (X-Y)
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int[] findOptimalMath(int[] nums) {
        long n = nums.length;

        long Sn  = (n * (n + 1)) / 2;
        long S2n = (n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0, S2 = 0;
        for (int num : nums) {
            S  += num;
            S2 += (long) num * num;
        }

        long diffXY   = S  - Sn;           // X - Y
        long sumXY    = (S2 - S2n) / diffXY; // X + Y

        long X = (sumXY + diffXY) / 2;     // repeating
        long Y = X - diffXY;               // missing

        return new int[]{(int) X, (int) Y};
    }

    // ─────────────────────────────────────────────
    // Approach 4: Optimal 2 – XOR Bit Manipulation
    // XOR all elements and 1..N → xr = X ^ Y.
    // Find rightmost set bit of xr.
    // Split numbers into two groups by that bit.
    // XOR within each group → gives X and Y.
    // Verify by counting: whichever appears twice is repeating.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int[] findOptimalXOR(int[] nums) {
        int n = nums.length;
        int xr = 0;

        // XOR all array elements and 1 to N
        for (int num : nums) xr ^= num;
        for (int i = 1; i <= n; i++) xr ^= i;

        // Rightmost set bit
        int setBit = xr & ~(xr - 1);

        int zero = 0, one = 0;

        // Separate into two groups
        for (int num : nums) {
            if ((num & setBit) != 0) one ^= num;
            else zero ^= num;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) one ^= i;
            else zero ^= i;
        }

        // Identify which is repeating and which is missing
        int countZero = 0;
        for (int num : nums) {
            if (num == zero) countZero++;
        }

        if (countZero == 2) return new int[]{zero, one};
        else return new int[]{one, zero};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        int[] r1 = findBrute(nums);
        System.out.println("Brute Force     → Repeating: " + r1[0] + ", Missing: " + r1[1]);

        int[] r2 = findBetter(nums);
        System.out.println("Better (Hash)   → Repeating: " + r2[0] + ", Missing: " + r2[1]);

        int[] r3 = findOptimalMath(nums);
        System.out.println("Optimal (Math)  → Repeating: " + r3[0] + ", Missing: " + r3[1]);

        int[] r4 = findOptimalXOR(nums);
        System.out.println("Optimal (XOR)   → Repeating: " + r4[0] + ", Missing: " + r4[1]);
    }
}
