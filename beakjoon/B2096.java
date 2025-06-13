import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2096{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp1 = new int[N][3];
        int[][] dp2 = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (i == N - 1) {
                    dp1[i][j] = value;
                    dp2[i][j] = value;
                } else {
                    dp1[i][j] = value;
                    dp2[i][j] = value;
                }
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp1[i][j] += Math.max(dp1[i + 1][j], dp1[i + 1][j + 1]);
                } else if (j == 2) {
                    dp1[i][j] += Math.max(dp1[i + 1][j], dp1[i + 1][j - 1]);
                } else {
                    dp1[i][j] += Math.max(dp1[i + 1][j], Math.max(dp1[i + 1][j - 1], dp1[i + 1][j + 1]));
                }
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp2[i][j] += Math.min(dp2[i + 1][j], dp2[i + 1][j + 1]);
                } else if (j == 2) {
                    dp2[i][j] += Math.min(dp2[i + 1][j], dp2[i + 1][j - 1]);
                } else {
                    dp2[i][j] += Math.min(dp2[i + 1][j], Math.min(dp2[i + 1][j - 1], dp2[i + 1][j + 1]));
                }
            }
        }

        int maxAnswer = 0;
        int minAnswer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            maxAnswer = Math.max(maxAnswer, dp1[0][i]);
            minAnswer = Math.min(minAnswer, dp2[0][i]);
        }
        System.out.println(maxAnswer + " " + minAnswer);
    }
}