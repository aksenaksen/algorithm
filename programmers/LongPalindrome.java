class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if (isPalindrome(s, i, j)) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }


        return answer;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}