class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int [][] sum = new int[board.length+1][board[0].length+1];
        
        for(int[] skill: skills){
            opration(sum,skill);
        }
        calculate(sum);
       
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] + sum[i][j] >= 1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void calculate(int [][] sum){
        for(int i=0; i<sum.length; i++){
            for(int j=1; j<sum[0].length; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        for(int j=0; j<sum[0].length; j++){
            for(int i=1; i<sum.length; i++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
    }
    
    
    private void opration(int [][] sum , int[] skill){
        int type = skill[0];
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
    
        int value = (type == 1) ? -degree : degree;

        sum[r1][c1] += value;
        sum[r2+1][c2+1] += value;
        sum[r1][c2+1] -= value;
        sum[r2+1][c1] -= value;
}

}