import java.util.*;

class Solution {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = picks[0] + picks[1] + picks[2];
        int chunkCount = Math.min((minerals.length + 4) / 5, totalPicks); // ← 버그 수정 포함
        List<int[]> chunks = new ArrayList<>();

        for (int i = 0; i < chunkCount; i++) {
            int dia = 0, iron = 0, stone = 0;
            int start = i * 5;
            int end = Math.min(start + 5, minerals.length);
            for (int j = start; j < end; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    dia += 1;
                    iron += 5;
                    stone += 25;
                } else if (m.equals("iron")) {
                    dia += 1;
                    iron += 1;
                    stone += 5;
                } else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
            }
            int[] chunk = new int[]{dia, iron, stone};
            chunks.add(chunk);


        }

        chunks.sort((a,b) -> b[2] - a[2]);



        for(int[] chunk: chunks){
            if(picks[0] > 0){
                answer += chunk[0];
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += chunk[1];
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += chunk[2];
                picks[2]--;
            }
        }

        return answer;
    }
}
