import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // n 운행횟수 , t 셔틀 운행 간격, m한번에 탈 수 있는 최대 명수

        String answer = "";
        int result = 0;
        Arrays.sort(timetable);
        List<Integer> crew = new ArrayList<>();

        for(String time : timetable){
            String[] times = time.split(":");
            int minutes = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            crew.add(minutes);
        }
        int idx = 0;
        int startBus = 9 * 60;
        for (int i=0; i<n; i++){

            int busIdx = 0;
            while(busIdx < m && idx < crew.size() && crew.get(idx) <= startBus){
                idx++;
                busIdx++;
            }

            if(i == n-1){
//                 마지막 버스
                if(busIdx < m){
                    result = startBus;
                }
                else{
                    result = crew.get(idx-1)-1;
                }
            }
            startBus += t;
        }


        answer = String.format("%02d:%02d",result/60,result % 60);
        return answer;
    }
}