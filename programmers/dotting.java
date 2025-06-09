class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(int i = 0; i <= d; i += k)
        {
            long D = (long) d*d;
            long I = (long) i*i;
            int result = (int) Math.sqrt(D - I);
            answer += (result/k) + 1;
        }
        return answer;
    }
}