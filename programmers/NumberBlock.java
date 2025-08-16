class Solution {
    public int[] solution(long begin, long end) {
        int length = (int)(end - begin + 1);
        int[] answer = new int[length];

        for(long i = begin; i <= end; i++){
            int idx = (int)(i - begin);
            answer[idx] = (i == 1) ? 0 : isPrime(i);
        }

        return answer;
    }

    public int isPrime(long num) {
        int maxDivisor = 1; // 블록 번호는 1 이상
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                long divisor = num / i;
                if (divisor <= 10000000) {
                    return (int) divisor;
                } else {
                    if (i <= 10000000) {
                        maxDivisor = (int) i;
                    }
                }
            }
        }
        return maxDivisor;
    }
}