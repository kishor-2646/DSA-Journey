import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] >= n)
            {
                System.out.println(i);
                flag = false;
                break;
            }

        }
        if(flag)
         System.out.println(arr.length);
    }
}
