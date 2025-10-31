import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public static int dist [];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> [] graph = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[node1].add(new Node(node2, cost));
            graph[node2].add(new Node(node1, cost));
        }

        dijkstra(N,1,graph);

        System.out.println(dist[N]);
    }

    public static void dijkstra(int N, int start , List<Node> [] graph){

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){

            Node curNode = pq.poll();

            for( Node next : graph[curNode.v]){
                int nextCost = curNode.cost + next.cost;
                if( nextCost < dist[next.v]){
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v , nextCost));
                }
            }

        }

    }
}
