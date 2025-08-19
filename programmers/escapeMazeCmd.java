import java.util.*;

class Solution {
    class Point{
        int x;
        int y;
        int dist;
        String path;

        public Point(int x, int y, int dist, String path){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
    }

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] directions = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minDist = Math.abs(x - r) + Math.abs(y - c);

        if (k < minDist || (k - minDist) % 2 != 0) {
            return "impossible";
        }
        x--;
        y--;
        r--;
        c--;
        Queue<Point> q = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        q.offer(new Point(x, y, 0, ""));
        visited.put(x + "," + y + "," + 0, 0);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == r && cur.y == c && cur.dist == k) {
                return cur.path;
            }

            if (cur.dist >= k) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int newDist = cur.dist + 1;
                String newPath = cur.path + directions[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int remainingDist = Math.abs(nx - r) + Math.abs(ny - c);
                    int remainingMoves = k - newDist;

                    if (remainingDist <= remainingMoves && (remainingMoves - remainingDist) % 2 == 0) {
                        String key = nx + "," + ny + "," + newDist;
                        if (!visited.containsKey(key)) {
                            visited.put(key, newDist);
                            q.offer(new Point(nx, ny, newDist, newPath));
                        }
                    }
                }
            }
        }

        return "impossible";
    }
}