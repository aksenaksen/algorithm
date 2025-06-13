import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16236{

    static int [][] board;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int answer = 0;

        int [] start = new int[2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int shark = Integer.parseInt(st.nextToken());
                board[i][j] = shark;
                if(shark == 9){
                    start[0] = i;
                    start[1] = j;
                    board[i][j] = 0;
                }
            }
        }
        int curSize = 2;
        int eatCount = 0;  // 현재 크기에서 먹은 물고기 수

        while(true){
            PriorityQueue<Shark> pq = new PriorityQueue<>((a,b) ->{
                if(a.dist == b.dist && a.x == b.x){
                    return a.y - b.y;
                }
                else if(a.dist == b.dist) return a.x - b.x;
                return a.dist - b.dist;
            });

            pq.offer(new Shark(start[0], start[1], 0));
            boolean [][] visited = new boolean[N][N];
            visited[start[0]][start[1]] = true;

            boolean foundFish = false;  // 이번 탐색에서 물고기를 찾았는지

            while(!pq.isEmpty()){
                Shark cur = pq.poll();

                // 먹을 수 있는 물고기를 발견한 경우
                if (board[cur.x][cur.y] != 0 && board[cur.x][cur.y] < curSize) {
                    start[0] = cur.x;
                    start[1] = cur.y;
                    eatCount++;
                    board[cur.x][cur.y] = 0;
                    answer += cur.dist;
                    foundFish = true;
                    break;
                }

                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]){
                        continue;
                    }
                    if(board[nx][ny] > curSize) continue;

                    visited[nx][ny] = true;  // 큐에 넣을 때 visited 설정
                    pq.offer(new Shark(nx, ny, cur.dist + 1));
                }
            }

            if(!foundFish){
                break;
            }

            if(eatCount == curSize){
                curSize++;
                eatCount = 0;
            }
        }

        System.out.println(answer);
    }

    public static class Shark{
        int x;
        int y;
        int dist;

        public Shark(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}