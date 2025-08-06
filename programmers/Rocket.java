import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) -> {
            if(b[1] == a[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        double rocket = targets[0][1] - 0.5;
        answer++;

        for(int [] target : targets){

            if(rocket < target[1] && rocket > target[0]){
                continue;
            }
            rocket = target[1] - 0.5;
            answer++;
        }

        return answer;
    }
}