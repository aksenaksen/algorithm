import java.util.*;

class Solution {

    class Node{
        int index;
        int x;
        int y;
        Node left;
        Node right;

        public Node (int index,int x, int y, Node right, Node left){
            this.index = index;
            this.x = x;
            this.y = y;
            this.right = right;
            this.left =left;
        }
    }

    int index = 0;


    public int[][] solution(int[][] nodeinfo) {

        Node[] nodes = new Node[nodeinfo.length];
        int [][] answer = new int[2][nodeinfo.length];

        for(int i=0;i<nodeinfo.length;i++){
            nodes[i]=new Node(i+1,nodeinfo[i][0],nodeinfo[i][1],null,null);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if(o2.y == o1.y){
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        Node root = nodes[0];
        for(int i=1; i<nodes.length; i++){
            insertNode(root, nodes[i]);
        }

        preOrder(root,answer);
        index = 0;
        postOrder(root,answer);

        return answer;
    }

    public void preOrder(Node node,int [][] answer){
        if(node != null){
            answer[0][index++] = node.index;
            preOrder(node.left,answer);
            preOrder(node.right,answer);
        }
    }

    public void postOrder(Node node,int [][] answer){
        if(node != null){
            postOrder(node.left,answer);
            postOrder(node.right,answer);
            answer[1][index++] = node.index;
        }
    }

    public void insertNode(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }
            else{
                insertNode(parent.left ,child);
            }
        }
        else{
            if(parent.right == null){
                parent.right = child;
            }
            else{
                insertNode(parent.right ,child);
            }
        }
    }
}