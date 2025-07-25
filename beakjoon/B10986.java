import java.util.Scanner;

//누적합 응용
public class Main {
    public static void main(String[] args) {
        long answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long sum = 0;
        long[] modList = new long[M];

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            sum += num;

            int mod = (int)((sum % M + M) % M);

            if(mod == 0){
                answer++;
            }
            answer += modList[mod];
            modList[mod]++;
        }

        System.out.println(answer);
    }
}