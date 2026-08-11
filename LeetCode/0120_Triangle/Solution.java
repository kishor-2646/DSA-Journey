class Solution {
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


}

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
