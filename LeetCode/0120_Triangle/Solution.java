class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle, 0, 0);
    }

    public int solve(List<List<Integer>> triangle, int row, int col)
    {
        if(row == triangle.size() - 1)
            return triangle.get(row).get(col);
        
        int left = solve(triangle,row+ 1,col);
        int right = solve(triangle, row+ 1, col+ 1);

        return triangle.get(row).get(col) + Math.min(left,right);
    }
}