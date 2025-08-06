import java.util.*;

class Solution {
    static class Node {
        int index;
        Node prev, next;

        Node(int index) {
            this.index = index;
        }
    }

    public String solution(int n, int k, String[] cmds) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, true);

        Node head = new Node(0);
        Node prev = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            prev.next = node;
            node.prev = prev;
            prev = node;
        }

        Stack<Node> stack = new Stack<>();

        Node cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        for(String cmd : cmds){
            String[] parseCmd = cmd.split(" ");

            if(parseCmd[0].equals("D")){
                int move = Integer.parseInt(parseCmd[1]);
                for (int i = 0; i < move; i++) {
                    cur = cur.next;
                }
            }
            else if(parseCmd[0].equals("U")){
                int move = Integer.parseInt(parseCmd[1]);
                for (int i = 0; i < move; i++) {
                    cur = cur.prev;
                }
            }
            else if(parseCmd[0].equals("C")){
                Node node = cur;
                if (node.prev != null) {
                    node.prev.next = node.next;
                }
                if (node.next != null){
                    node.next.prev = node.prev;
                }
                visited[node.index] = false;
                stack.add(node);

                if (node.next != null) {
                    cur = node.next;
                } else {
                    cur = node.prev;
                }
            }
            else if(parseCmd[0].equals("Z")){
                Node node = stack.pop();
                if (node.prev != null){
                    node.prev.next = node;
                }
                if (node.next != null){
                    node.next.prev = node;
                }
                visited[node.index] = true;
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            if (!visited[i]) {
                answer.append("X");
            } else {
                answer.append("O");
            }
        }

        return answer.toString();
    }

}