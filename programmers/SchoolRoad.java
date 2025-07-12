import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        int mod = 1_000_000_007;
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || isPuddle(i, j, puddles)) continue;

                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= mod;
            }
        }

        return dp[n - 1][m - 1];
    }

    public boolean isPuddle(int i, int j, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (puddle[1] - 1 == i && puddle[0] - 1 == j) {
                return true;
            }
        }
        return false;
    }
}
