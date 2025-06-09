import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int score1 = scores[0][0];
        int score2 = scores[0][1];
        int sum = score1+score2;

        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]){
                return a[1]- b[1];
            }
            return b[0] - a[0];
        });

        int prev = 0;
        int rank = 1;

        for(int[] score: scores){
            if(score1 < score[0] && score2 < score[1]){
                return -1;
            }

            if(prev <= score[1]){
                prev = score[1];
                if(score[0]+ score[1] > sum){
                    rank++;
                }
            }

        }

        return rank;
    }
}