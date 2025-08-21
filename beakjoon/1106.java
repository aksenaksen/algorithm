import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int N = sc.nextInt();

        int[][] city = new int[N][2];
        for (int i = 0; i < N; i++) {
            int cost = sc.nextInt();
            int customer = sc.nextInt();
            city[i][0] = cost;
            city[i][1] = customer;
        }
        int dp[] = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<N; i++){
            int customer = city[i][1];
            int cost = city[i][0];
            for(int j = customer; j < C + 101; j++){
                if (dp[j - customer] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - customer]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=C; i<C+101; i++){
            min = Math.min(dp[i], min);
        }
        System.out.println(min);
    }
}
