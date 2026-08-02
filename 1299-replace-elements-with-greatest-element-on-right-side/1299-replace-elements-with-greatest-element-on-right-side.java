class Solution {
    public int[] replaceElements(int[] arr) {
          int max = 0;

          for(int i = arr.length - 1; i >= 0; i--)
          {
            int curr = arr[i];

            if(max == 0)
                {
                arr[i] = -1;
                max = Math.max(curr, max); 
                continue;
                }

            arr[i] = max;

            max = Math.max(curr, max); 
          }

          return arr;
    }

    //Simplified version 

    public int[] replaceElements2(int[] arr) {
        int maxRight = -1;

        for(int i = arr.length - 1; i >= 0; i--)
        {
            int curr = arr[i];
            arr[i] = maxRight;
            maxRight = Math.max(curr, maxRight);
        }
        return arr;
    }
}
