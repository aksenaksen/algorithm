import java.util.*;

class Solution {

    public int solution(String name) {

        int answer = 0;
        int length = name.length();
        int move = length - 1;
        for(int i=0; i<length; i++){
            char c = name.charAt(i);
            answer+= Math.min(c - 'A', 'Z' - c + 1);

            int idx = i + 1;
            while(idx < length && name.charAt(idx) == 'A'){
                idx++;
            }

            move = Math.min(move, i * 2 + length - idx);
            move = Math.min(move, (length - idx) * 2 + i);

        }
        return answer + move;
    }


}