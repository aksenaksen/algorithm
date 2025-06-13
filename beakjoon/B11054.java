import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11054{

//가장 긴 바이토닉 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] rDp = new int [N];
        int [] lDp = new int [N];
        int [] arr = new int [N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        최장 부분수열 앞 뒤로 계산
        for(int i = 0; i < N; i++){
            rDp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    rDp[i] = Math.max(rDp[i], rDp[j]+1);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            lDp[i] = 1;
            for(int j=N-1; j>=i; j--){
                if(arr[j] < arr[i]){
                    lDp[i] = Math.max(lDp[i], lDp[j]+1);
                }
            }
        }
// 후 더한값의 최댓값에서 중복 제거
        for(int i=0; i<N; i++){
            int sum = lDp[i]+rDp[i];
            answer = Math.max(answer, sum -1);
        }
        System.out.println(answer);
    }

}