import java.util.*;

class Solution {

    ArrayList<Integer> [] graph;
    int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        graph = new ArrayList[info.length];
        boolean [] visited = new boolean[info.length];
        for(int i=0; i<info.length; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            graph[node1].add(node2);
        }

        Set<Integer> canVisit = new HashSet<>();
        canVisit.add(0);

        dfs(info, canVisit, 0, 0);


        return maxSheep;
    }


    public void dfs(int [] info, Set<Integer> canVisit,int sheep, int wolf){

        maxSheep = Math.max(sheep,maxSheep);

        for(int next : canVisit){

            int nextSheep = sheep + (info[next] == 0 ? 1 : 0);
            int nextWolf = wolf + (info[next] == 1 ? 1 : 0);

            if(nextSheep <= nextWolf){
                continue;
            }

            Set<Integer> newSet = new HashSet<>(canVisit);
            newSet.remove(next);

            for(int node : graph[next]){
                newSet.add(node);
            }


            dfs(info,newSet, nextSheep, nextWolf);
        }

    }
}