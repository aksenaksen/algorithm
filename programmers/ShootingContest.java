class Solution {
    int [] peach;
    int [] lion;
    int [] answer;
    int maxSum = 0;

    public int[] solution(int n, int[] info) {
        peach = info.clone();
        lion = new int[11];

        backtrack(n , 0);

        if (maxSum == 0){
            return new int[]{-1};
        }
        return answer;
    }

    public void backtrack(int n, int depth){
        if(n == depth){
            int tmp = calculate();
            if(tmp >= maxSum){
                maxSum = tmp;
                for(int i=0; i< lion.length; i++){
                    System.out.print(lion[i] + " ");
                }
                System.out.println();
                answer = lion.clone();
            }
            return;
        }

        for(int i=0; i < 11; i++){

            if(peach[i] < lion[i]){
                break;
            }

            lion[i] += 1;
            backtrack(n , depth+1);
            lion[i] -= 1;
        }
    }

    public int calculate(){
        int lionScore = 0;
        int peachScore = 0;

        for(int i=0; i<11; i++){
            if(peach[i] == 0 && lion[i] == 0) continue;

            if(peach[i] < lion[i]){
                lionScore += 10 - i;
            } else {
                peachScore += 10 - i;
            }
        }

        return lionScore - peachScore;
    }

}