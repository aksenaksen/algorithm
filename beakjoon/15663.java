import java.util.*;
import java.io.*;

class Main {
    public static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        boolean[] visited = new boolean[N];
        perm(numbers, M, 0, new ArrayList<>(), visited);
    }

    public static void perm(int[] numbers, int M, int depth, List<Integer> path, boolean[] visited){

        if(depth == M){
            if(!set.contains(path)){
                set.add(new ArrayList<>(path));
                for(int n : path){
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int i = 0; i < numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                path.add(numbers[i]);
                perm(numbers, M, depth + 1, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
