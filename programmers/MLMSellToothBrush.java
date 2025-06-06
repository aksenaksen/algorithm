import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        //다단계 이익은 10% 1원미만은 분배안함. 칫솔판매시 이익은 100원
        Map<String, Integer> costMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();

        for(int i=0; i<enroll.length; i++){
            costMap.put(enroll[i], 0);
            parentMap.put(enroll[i],referral[i]);
        }

        for(int i=0; i<seller.length; i++){
            int cost = amount[i] * 100;
            String people = seller[i];
            while(true){
                if(people.equals("-") || cost <= 0){
                    break;
                }

                costMap.put(people, costMap.get(people) + (cost - (cost/10)));
                people = parentMap.get(people);
                cost /= 10;
            }
        }

        for(int i=0; i<enroll.length; i++){
            answer[i] = costMap.get(enroll[i]);
        }

        return answer;
    }
}