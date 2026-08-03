class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] ans = new int[rows * cols];

        int r = 0, c = 0;
        boolean up = true;

        for (int k = 0; k < rows * cols; k++) {

            ans[k] = mat[r][c];

            if (up) {

                // Right boundary
                if (c == cols - 1) {
                    r++;
                    up = false;
                }
                // Top boundary
                else if (r == 0) {
                    c++;
                    up = false;
                }
                // Normal move
                else {
                    r--;
                    c++;
                }

            } else {

                // Bottom boundary
                if (r == rows - 1) {
                    c++;
                    up = true;
                }
                // Left boundary
                else if (c == 0) {
                    r++;
                    up = true;
                }
                // Normal move
                else {
                    r++;
                    c--;
                }
            }
        }

        return ans;
    }
}