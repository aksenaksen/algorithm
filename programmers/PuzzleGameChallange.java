class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
//         diff <= level = time_cur, diff> level diff-level 틀림, 틀릴때마다 time_cur 그리고 time_prev만큼 시간을 사용해 이전 퍼즐을 다시 풀고와야함. 틀리지않는대 이전퍼즐은 , 숙련도 최솟값이면 이분탐색인거같은데
        int start =1;
        int end = 100000;

        while(start <= end){
            int level = (start + end) / 2;

            long t = 0;
            long prevTime = 0;
            for(int i=0; i< diffs.length; i++){
                if(diffs[i] <= level){
                    t += times[i];
                }
                else{
                    int wrong = diffs[i] - level;
                    t += wrong * (times[i] + prevTime) + times[i];
                }
                prevTime = times[i];
            }

            if(t <= limit){
                answer = level;
                end = level-1;
            }
            else{
                start = level+1;
            }
        }

        return answer;
    }

}