import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int size = 1; size <= s.length() / 2; size++) {
            StringBuilder sb = new StringBuilder();
            String sub = s.substring(0, size);
            int cnt = 1;

            for (int i = size; i <= s.length() - size; i += size) {
                String sub2 = s.substring(i, i + size);
                if (sub.equals(sub2)) {
                    cnt++;
                } else {
                    if (cnt > 1) sb.append(cnt);
                    sb.append(sub);
                    sub = sub2;
                    cnt = 1;
                }
            }

            if (cnt > 1) sb.append(cnt);
            sb.append(sub);

            if (s.length() % size != 0) {
                sb.append(s.substring(s.length() - (s.length() % size)));
            }

            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}
//사용자 변경