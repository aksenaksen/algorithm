
import java.util.*;




class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 작업 소요시간, 작업 요청시각, 작업번호가 작은것 순으로 우선순위가 높다.
        // 비선점 스케줄링
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int time = jobs[0][0];
        int i=0;
        int cnt = 0;
        while(cnt < jobs.length){

            while(i < jobs.length && time >= jobs[i][0]){
                pq.offer(new int [] {jobs[i][0], jobs[i][1]});
                i++;
            }

            if(pq.isEmpty()){
                time = jobs[i][0];
            }
            else{
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                cnt++;
            }

        }

        return answer/jobs.length;
    }
}