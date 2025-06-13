import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1068{

    public static class Node{

        int parent;
        int node;
        List<Node> child = new ArrayList<>();


        public Node(int node){
            this.node = node;
        };

    }

    public static Node [] nodes;
    public static boolean [] visited;
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        visited = new boolean[N];
        int root=0;
        for(int i = 0; i < N; i++){
            nodes[i] = new Node(i);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                nodes[i].parent = -1;
                continue;
            }
            nodes[i].parent = parent;
            nodes[parent].child.add(nodes[i]);
        }
        int deleteNode = Integer.parseInt(br.readLine());
        int parentNode = nodes[deleteNode].parent;

        if(parentNode == -1){
            System.out.println(0);
            return;
        }
        else{
            nodes[parentNode].child.remove(nodes[deleteNode]);
            nodes[deleteNode].parent=-1;
        }
        dfs(nodes[root]);
        System.out.println(answer);
    }
    public static void dfs(Node root){
        if(root.child.size() == 0){

            answer ++;
            return;
        }

        for(Node child: root.child){

            if(!visited[child.node])
            {
                visited[child.node] = true;
                dfs(child);
            }

        }
    }
}