import java.util.*;

class Node {
    int x, y, dir, cost;
    Node(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][][] cost = new int[n][n][4];

        for (int[][] row : cost)
            for (int[] cell : row)
                Arrays.fill(cell, Integer.MAX_VALUE);

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0;
            q.offer(new Node(0, 0, i, 0));
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int newCost = cur.cost + ((cur.dir == i) ? 100 : 600);

                if (newCost < cost[nx][ny][i]){
                    cost[nx][ny][i] = newCost;
                    q.offer(new Node(nx, ny, i, newCost));
                }


            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n - 1][n - 1][i]);
        }

        return answer;
    }
}
