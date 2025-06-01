import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long start = 0;
        long end = (long) times[times.length - 1] * n;


        while(start <= end){

            long mid = (start + end) / 2;
            long cnt = 0;
            for(int time : times){
                cnt += mid / time;
            }

            if(cnt >= n){
                answer = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        return answer;
    }
}