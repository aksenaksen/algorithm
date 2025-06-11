package tobyspring.userservice.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1939 {

    static class Node{
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    public static List<Node> [] island;
    public static boolean [] visited;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        island = new ArrayList[N+1];
        for(int i=1; i<=N;i++){
            island[i] = new ArrayList<>();
        }

        int start = 0;
        int end = 0;


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            island[node1].add(new Node(node2, weight));
            island[node2].add(new Node(node1, weight));
            end = Math.max(end,weight);
        }
        st = new StringTokenizer(br.readLine());
        int startIsland = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        while(start<=end){
            int mid = (start+end)/2;
            visited = new boolean[N+1];
            if(dfs(mid, startIsland, target)){
                answer = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }

        }
        System.out.println(answer);
    }

    public static boolean dfs(int limit, int cur, int target){
        if(cur == target){
            return true;
        }

        visited[cur] = true;

        for(Node node : island[cur]){
            if(!visited[node.next] && node.weight >= limit){
                if(dfs(limit, node.next, target)) return true;
            }
        }
        return false;
    }
}

