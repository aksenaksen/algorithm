import java.util.*;
class Edge{
    int e;
    int cost;

    Edge(int e, int cost){
        this.e = e;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int INF = Integer.MAX_VALUE;

        List<Edge> [] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] fare : fares){
            graph[fare[1]].add(new Edge(fare[0],fare[2]));
            graph[fare[0]].add(new Edge(fare[1],fare[2]));
        }
        int [] dpS = dijkstra(s,n,graph);
        int [] dpA = dijkstra(a,n,graph);
        int [] dpB = dijkstra(b,n,graph);

        for(int i=1; i<=n; i++){
            int dist = dpS[i] + dpA[i] + dpB[i];
            answer = Math.min(answer, dist);
        }

        return answer;
    }

    public int[] dijkstra(int start,int n, List<Edge>[] graph){

        int [] dp = new int[n+1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[start] = 0;
//      다익스트라 시작 정점들 무한으로 초기화 후 시작만 0으로
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) ->
                a.cost - b.cost);
        pq.offer(new Edge(start, 0));
//      이후 우선순위 큐에 해당 정점 삽입
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int node = cur.e;
            int curCost = cur.cost;
//          우선순위 큐에서 해당 정점과 비용을 꺼낸다.
            if(curCost > dp[node]) continue;
//          만약 현재 cost보다 이미 더 작은 경로가 있다면 건너뛴다. why? 했던 정점을 또 검사할 수 있음.
            for(Edge next : graph[node]){
                if(dp[next.e] > curCost + next.cost){
                    dp[next.e] = curCost + next.cost;
                    pq.offer(new Edge(next.e, dp[next.e]));
                }
            }

        }

        return dp;
    }
}
