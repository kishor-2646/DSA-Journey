package Experiences_And_OldPapers.Set0001;

import java.util.Arrays;
// Problem link : https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1
public class GoldMine {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4} };

        int mat2[][] = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

      //for approach 1
    /*    int ans = 0;

        for(int row = 0; row < mat2.length; row++)
        {
            int gold = collectGold(row,0,mat2);
            ans = Math.max(ans,gold);
        }

        System.out.println(ans);
    */

        // for approach 2
        /*
        System.out.println(collectGoldBetter(mat));
        System.out.println(collectGoldBetter(mat2));
        */

        // for approach 4
        System.out.println(maxGold(mat));
        System.out.println(maxGold(mat2));

    }

    //Approach 1(Naive)
    //Recursive DFS :Time Complexity: O(3^(n * m)) , Auxiliary Space: O(n × m)
    public static int collectGold(int row, int col, int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        if(row < 0 || row >= n || col >= m)
            return 0;

        int rightUp = collectGold(row - 1, col + 1, mat);
        int right = collectGold(row, col + 1, mat);
        int rightDown = collectGold(row + 1, col + 1, mat);

        return mat[row][col] + Math.max(Math.max(rightDown,right),rightUp);
    }



    //Approach 2
    //Top-Down Dynamic Programming (Memoization) - O(n×m) Time and O(n×m) Space
    public static int collectGoldBetter(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;

        // using memoization
        int[][] dp = new int[n][m];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        int ans = 0;
        for(int row = 0; row < n; row++)
        {
            int gold = getGold(row, 0, mat, dp);
            ans = Math.max(ans,gold);
        }
        return ans;
    }

    public static int getGold(int r, int c, int[][] mat, int[][] dp)
    {
        int n = mat.length;
        int m = mat[0].length;

        if(r < 0 || r >= n || c >= m)
            return 0;

        if(dp[r][c] != -1)
            return dp[r][c];

        int RU = getGold(r - 1, c + 1, mat, dp);
        int R = getGold(r, c + 1, mat, dp);
        int RD = getGold(r + 1, c + 1, mat, dp);

        return dp[r][c] = mat[r][c] + Math.max(Math.max(RU, R), RD);
    }






    //Approach 3
    //Space-Optimized Tabulation – O(n×m) Time and O(n) Space
    static int maxGold2(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        // initialize prev with the last column of the matrix
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = mat[i][m - 1];
        }

        // move from second-last column to the first
        for (int y = m - 2; y >= 0; y--) {
            int[] curr = new int[n];

            for (int x = 0; x < n; x++) {

                // move to the right-upper cell
                int rightUpper = (x > 0) ? prev[x - 1] : 0;

                // move directly to the right
                int right = prev[x];

                // move to the right-lower cell
                int rightLower = (x < n - 1) ? prev[x + 1] : 0;

                // store the max gold from the three options
                curr[x] = mat[x][y] +
                        Math.max(Math.max(rightUpper, right), rightLower);
            }

            // update prev to current for the next iteration
            prev = curr;
        }

        // find the maximum in the final prev array
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, prev[i]);
        }

        return result;
    }

    // Approach 4
    //In-place Dynamic Programming from Right to Left - O(n×m) Time ans O(1) Space
    public static int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        for(int j = m - 2; j >= 0; j--)
        {
            for(int i = 0; i < n; i++)
            {
                int RU = 0;
                int R = 0;
                int RD = 0;

                if(i - 1 >= 0 && j + 1 < m)
                    RU = mat[i - 1][j + 1];

                if(j + 1 < m)
                    R = mat[i][j + 1];

                if(j + 1 < m && i + 1 < n)
                    RD = mat[i + 1][j + 1];

                mat[i][j] += Math.max(Math.max(RU, R), RD);
            }
        }

        int ans = 0;
        for(int row = 0; row < n; row++)
        {
            ans = Math.max(mat[row][0], ans);
        }
        return ans;
    }
}
