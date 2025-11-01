import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int cnt = 0;
    public static int width = 0;
    public static boolean [][] visited;
    public static int [][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        int maxWidth = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i  = 0; i < n; i++){

            for(int j = 0; j < m ; j ++){
                if(board[i][j] == 1 && !visited[i][j]){
                    width = 1;
                    dfs(j,i,m,n);
                    maxWidth = Math.max(width, maxWidth);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxWidth);
    }

    public static void dfs(int x,int y,int m, int n){

        visited[y][x] = true;

        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};

        for(int dir = 0; dir < 4; dir ++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >=0 && ny >= 0 && nx < m && ny < n && board[ny][nx] == 1 && !visited[ny][nx]){
                width++;
                dfs(nx,ny, m, n);
            }
        }
    }
}