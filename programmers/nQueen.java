class Solution {

    private static int[] board;
    private static int answer = 0;


    public int solution(int n) {
        board = new int[n];
        nQueen(0,n);

        return answer;
    }
    public void nQueen(int depth,int n){
        if(depth == n){
            answer++;
            return;
        }



        for(int i=0; i<n; i++){
            board[depth] = i;
            if(isPossiable(depth)){
                nQueen(depth + 1, n);
            }
        }
    }


    public boolean isPossiable(int depth){
        for(int i=0; i < depth; i++){
            if(board[depth] == board[i]) return false;
            if(Math.abs(i - depth) == Math.abs(board[i] - board[depth])) return false;
        }
        return true;
    }
}