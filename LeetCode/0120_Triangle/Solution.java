class Solution {


public int minimumTotal(List<List<Integer>> triangle) {

                int n = triangle.size();

                int[] dp = new int[n];

                for(int j = 0; j < n; j++)
                {
                    dp[j] = triangle.get(n - 1).get(j);
                }

                for(int i = n - 2; i >= 0; i--)
                {
                    for(int j = 0; j <= i; j++)
                    {
                        dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
                    }
                }

                return dp[0];
         
}

         /*
         
          public int minimumTotal(List<List<Integer>> triangle) {

                int n = triangle.size();

                int[][] dp = new int[n][n];

                for(int j = 0; j < n; j++)
                {
                    dp[n - 1][j] = triangle.get(n - 1).get(j);
                }

                for(int i = n - 2; i >= 0; i--)
                {
                    for(int j = 0; j <= i; j++)
                    {
                        dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                    }
                }

                return dp[0][0];
         } */

}


 /* 
 Using recursion + memorization T(N) = O(N^2) S(N) = O(N^2)
 
 
 public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int[] num: dp)
        {
            Arrays.fill(num,Integer.MIN_VALUE);
        }
        
        return solve(triangle, 0, 0, dp);
    }



    private int solve(
            List<List<Integer>> triangle,
            int row,
            int col,
            int[][] dp)    {
        if(row == triangle.size() - 1)
            return triangle.get(row).get(col);
        
        if(dp[row][col] != Integer.MIN_VALUE)
            return dp[row][col];

        int left = solve(triangle, row + 1, col, dp);
        int right = solve(triangle, row + 1, col + 1, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);

        return dp[row][col];
    }
 */

  /*  
            Brute force approach T(N) = O(2^n)
  
   public int solve(List<List<Integer>> triangle, int row, int col)
    {
        if(row == triangle.size() - 1)
            return triangle.get(row).get(col);
        
        int left = solve(triangle,row+ 1,col);
        int right = solve(triangle, row+ 1, col+ 1);

        return triangle.get(row).get(col) + Math.min(left,right);
    } */
