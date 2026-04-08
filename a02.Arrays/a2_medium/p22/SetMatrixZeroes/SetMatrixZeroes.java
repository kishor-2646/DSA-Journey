package a1_easy.p22.SetMatrixZeroes;

public class SetMatrixZeroes {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Marker Value
    // When a 0 is found, mark entire row & column
    // with a special marker (-1) to avoid false
    // zeroing during the scan. Then replace all -1
    // with 0 in a second pass.
    //
    // T(n) = O(m×n × (m+n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void setZeroesBrute(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Marking pass
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Mark entire row as -1 (except existing zeroes)
                    for (int col = 0; col < n; col++) {
                        if (matrix[i][col] != 0) matrix[i][col] = -1;
                    }
                    // Mark entire col as -1 (except existing zeroes)
                    for (int row = 0; row < m; row++) {
                        if (matrix[row][j] != 0) matrix[row][j] = -1;
                    }
                }
            }
        }

        // Replacing pass
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Two Boolean Arrays
    // Use a boolean[] row and boolean[] col to
    // track which rows/columns need to be zeroed.
    // Two passes: first scan to mark, second to zero.
    //
    // T(n) = O(m×n), S(n) = O(m+n)
    // ─────────────────────────────────────────────
    public static void setZeroesBetter(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // Pass 1: mark rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Pass 2: set to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal – Use 1st Row & 1st Col
    // Instead of two extra arrays, use the 1st row
    // and 1st col of the matrix itself as markers.
    //
    // Catch: matrix[0][0] is shared — it belongs to
    // both 1st row and 1st col. So we handle 1st row
    // and 1st col separately with two booleans.
    //
    // Algorithm:
    // 1. Check if 1st row/col themselves contain 0
    // 2. Mark rows & cols using matrix[i][0] and matrix[0][j]
    //    (scan from (1,1) to (m-1, n-1))
    // 3. Zero out cells (i>0, j>0) using those markers
    // 4. Finally zero 1st row/col if needed
    //
    // T(n) = O(m×n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void setZeroesOptimal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) { firstRowZero = true; break; }
        }

        // Check first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) { firstColZero = true; break; }
        }

        // Mark rows & cols using first row and col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark col
                }
            }
        }

        // Apply zeroes using markers (skip first row & col)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // Zero first col if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroesOptimal(matrix);
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
        // [[1,0,1],[0,0,0],[1,0,1]]
    }
}
