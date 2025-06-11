
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];
        String[] pTokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(pTokens[i]);
        }

        int[] S = new int[N];
        String[] sTokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(sTokens[i]);
        }

        int[] current = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = i;
        }

        int[] init = current.clone();
        int cnt = 0;

        while (true) {
            if (isCorrect(current, P)) {
                System.out.println(cnt);
                return;
            }

            int[] next = new int[N];
            for (int i = 0; i < N; i++) {
                next[S[i]] = current[i];
            }

            current = next;
            cnt++;

            if (Arrays.equals(init, current)) {
                System.out.println(-1);
                return;
            }
        }
    }

    public static boolean isCorrect(int[] cur, int[] P) {
        for (int i = 0; i < cur.length; i++) {
            if (P[cur[i]] != i % 3) {
                return false;
            }
        }
        return true;
    }
}
