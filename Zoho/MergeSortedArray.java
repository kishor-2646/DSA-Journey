import java.util.Arrays;

public class MergeSortedArray {
public static void main(String[] args)
{   int[] a = {1,4,6,7,9,0,0,0,0};
    int[] b = {2,5,8,10};



    int n = 5;
    int m = b.length;

    int i = n - 1;
    int j = m - 1;
    int k = m + n - 1;
    while(i >= 0 && j >= 0)
    {
        if(a[i] >= b[j])
        {
            a[k--] = a[i--];
        }
        else
        {
            a[k--] = b[j--];
        }
    }
    while(j >= 0)
    {
        a[k--] = b[j--];
    }


    System.out.println(Arrays.toString(a));
}
}
