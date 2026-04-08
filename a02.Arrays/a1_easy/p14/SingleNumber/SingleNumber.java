package a1_easy.p14.SingleNumber;

public class SingleNumber {

    // Optimal: XOR Approach
    // XOR Properties:
    //   a ^ a = 0  (same numbers cancel out)
    //   a ^ 0 = a  (XOR with 0 gives itself)
    //   XOR is associative: (A^B)^C = A^(B^C)
    // So XOR-ing all elements leaves only the unique element.
    // T(n) = O(n), S(n) = O(1)
    public static int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 4, 1, 4};
        System.out.println(singleNumber(nums)); // Output: 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums2)); // Output: 4
    }
}
