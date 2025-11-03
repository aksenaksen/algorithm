import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, (a,b) ->  a[0] - b[0]);

            int cnt = 0;
            int minScore = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                if(minScore > applicants[i][1]){
                    cnt++;
                    minScore = applicants[i][1];
                }
            }

            System.out.println(cnt);
        }
    }
}