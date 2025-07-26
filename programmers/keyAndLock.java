class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int len = m + n -1;

        for(int i = 0; i < len; i++){
            for(int j=0; j< len; j++){
                for(int dir = 0; dir < 4; dir++){
                int [][] locks = new int[n + 2*(m-1)][n + 2*(m-1)];
                for(int r=0; r<n; r++){
                    for(int c=0; c<n; c++){
                        locks[r+m-1][c+m-1] = lock[r][c];
                    }
                }
                match(locks,i,j,dir,key);
                if(check(locks,n,m)){
                    printMatrix(locks);
                    return true;
                }
                }
            }
        }

        return false;
    }
    public void match(int[][] lock, int r, int c, int dir, int[][] key){
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                if(dir == 0){
                    lock[i+r][j+c] += key[i][j];
                }
                else if (dir == 1){
                    lock[i+r][j+c] += key[key.length - j - 1][i];
                }
                else if (dir == 2){
                    lock[i+r][j+c] += key[key.length - i - 1][key.length - j - 1];
                }
                else{
                    lock[i+r][j+c] += key[j][key.length - i -1];
                }
            }
        }

    }

    public boolean check(int [][] locks,int n, int m){

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(locks[r+m-1][c+m-1] != 1){
                    return false;
                }
            }
        }
        return true;
    }


    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}