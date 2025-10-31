import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 0;

        char prev = s.charAt(0);
        Stack<Character> stack = new Stack<>();
        stack.add(prev);

        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add('(');
            }
            else{
                stack.pop();
                if(prev == '('){
                    answer += stack.size();
                }
                else{
                    answer += 1;
                }
            }
            prev = s.charAt(i);
        }


        System.out.println(answer);
    }
}