package SkillRack.SmallerMatrixSearch;

import java.util.*;

public class MatrixSearch{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] big = new int[N][N];
        int[][] small = new int[M][M];

        // Read big matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                big[i][j] = sc.nextInt();
            }
        }

        // Read small matrix
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                small[i][j] = sc.nextInt();
            }
        }

        boolean found = false;

        // Try every possible starting position
        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j <= N - M; j++) {

                boolean match = true;

                // Compare M x M block
                for (int x = 0; x < M && match; x++) {
                    for (int y = 0; y < M; y++) {

                        if (big[i + x][j + y] != small[x][y]) {
                            match = false;
                            break;
                        }
                    }
                }

                if (match) {
                    found = true;
                    break;
                }
            }

            if (found)
                break;
        }

        System.out.println(found ? "TRUE" : "FALSE");
    }
}