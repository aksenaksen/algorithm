import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16928{

//    뱀과 사다리 게임
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] move = new int[N+M][2];

        for(int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//      100층까지라 BFS로 가능한듯.
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1,0});
        boolean [] visited = new boolean[101];

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            visited[cur[0]] = true;

            if(cur[0] == 100){
                answer = cur[1];
                break;
            }

            for(int i=1; i<=6; i++){
                int next = cur[0] + i;

                if(next > 100){
                    continue;
                }

                boolean tmp = false;
                for(int j=0; j<N+M; j++){
                    if(move[j][0] == next){
                        if(!visited[move[j][1]]){
                            q.add(new int[] {move[j][1],cur[1]+1});
                        }
                        tmp = true;
                        break;
                    }
                }

                if(!tmp && !visited[next]) {
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }
        System.out.println(answer);
    }
}