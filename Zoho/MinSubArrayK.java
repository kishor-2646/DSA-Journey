import java.util.Scanner;

public class MinSubArrayK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        int minLen = Integer.MAX_VALUE;
        int  j = 0;
        int sum = 0;
        for(int i = 0; i < n; i++)
        {

            sum += arr[i];
            while(sum >= k)
            {
                minLen = Math.min(minLen, i - j + 1);
                sum -= arr[j++];
            }


        }
        System.out.println(minLen);
    }
}
