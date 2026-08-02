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
}