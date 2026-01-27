import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++){
            HashMap<String , Integer> map = new HashMap<>();
            int c = Integer.parseInt(br.readLine());
            int typeCnt = 0;
            int result = 0;

            for(int i=0; i<c; i++){
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);

                String wear = st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            if(map.size() == 0) {
                System.out.println(0);
                continue;
            }

            result = 1;
            for(int num : map.values()){
                result *= (num + 1);
            }
            System.out.println(result-1);
        }
    }
}
