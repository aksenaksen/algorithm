import java.util.*;

class Solution {

    private static int[] dr = {1,-1,0,0};
    private static int[] dc = {0,0,1,-1};
    private static int[] cntList;
    private static int cnt;
    private static int group = 1;

    public int solution(int[][] land) {
        int answer = 0;
        int [][] visited = new int[land.length][land[0].length];
        List<Integer> groupAmount = new ArrayList<>();

        for(int j=0; j<land[0].length; j++){

            Set<Integer> set = new HashSet<>();
            int amount = 0;
            for(int i=0; i<land.length; i++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    cnt = 0;
                    dfs(i,j,land,visited);
                    groupAmount.add(cnt);
                    group++;
                }
                if(visited[i][j] != 0){
                    set.add(visited[i][j]);
                }
            }

            for(Integer item : set){
                amount += groupAmount.get(item-1);
            }
            answer = Math.max(answer,amount);
        }

        return answer;
    }
    public void printLand(int[][] land) {
        for (int[] row : land) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    public void dfs(int r, int c, int[][] land, int[][] visited){

        visited[r][c] = group;
        cnt++;


        for(int dir = 0; dir < 4; dir++){
            int nr = dr[dir] + r;
            int nc = dc[dir] + c;

            if(nr < 0 || nc < 0 || nr >= land.length || nc >= land[0].length|| visited[nr][nc]!=0){
                continue;
            }

            if(land[nr][nc] == 1){

                dfs(nr,nc,land,visited);
            }

        }
    }
}