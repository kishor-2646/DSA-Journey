package Experiences_And_OldPapers.Set0001;
/*
Find the Islands , given a 2D array you have to find the island
location.
Ex:
Input :[[1,1,0,0],
[0,0,1,0]]
Output : [(0,0),(0,1)],[(1,2)]

Related Leetcode Problem: 200. Number of Islands
 */
public class Islands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };

        int[][] grid2 = {
                {1, 1, 0, 0},
                {0, 0, 1, 0}
        };


        IslandCoordinates(grid);
        IslandCoordinates(grid2);
    }

    /*
    Most Optimal Solution : Using DFS + Grid Traversal
    T(N) = O(row * col)
    S(N) = O(row * col) you dont need to store and print the result , we can directly print the result without using stringBuilder also
     */
    public static void IslandCoordinates(int[][] grid)
    {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    res.append("[");   //  System.out.print("[");  ---------for direct printing

                    dfs(grid,i,j,res);

                    if(res.charAt(res.length() - 1) == ',')         //System.out.println("]");
                        res.deleteCharAt(res.length() - 1);

                    res.append("],");
                }
            }
        }
        res.deleteCharAt(res.length()-1);   // not needed
        System.out.println(res);                  // not needed
    }

    public static void dfs(int[][] grid, int r, int c, StringBuilder res)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)
            return;

        grid[r][c] = -1;

        res.append("(").append(r).append(",").append(c).append("),");   //     System.out.print("(" + r + "," + c + ")");

        dfs(grid,r+1,c,res);
        dfs(grid,r-1,c,res);
        dfs(grid, r,c+1,res);
        dfs(grid,r,c-1,res);

    }
}
