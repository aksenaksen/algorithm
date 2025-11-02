import java.util.*;
import java.io.*;

class Main {

    public static int[][] board;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int cnt = 0;
    public static List<Integer> widthList = new ArrayList<>();
    public static int width = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int y = ly; y < ry; y++) {
                for (int x = lx; x < rx; x++) {
                    board[M - y - 1][x] = 1;
                }
            }
        }

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (board[y][x] == 0) {
                    width = 1;
                    cnt++;
                    dfs(x, y, N, M);
                    widthList.add(width);
                }
            }
        }

        Collections.sort(widthList);

        System.out.println(cnt);
        for (int w : widthList) {
            System.out.print(w + " ");
        }
    }

    public static void dfs(int x, int y, int N, int M) {
        board[y][x] = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (board[ny][nx] == 0) {
                    board[ny][nx] = -1;
                    width++;
                    dfs(nx, ny, N, M);
                }
            }
        }
    }
}
