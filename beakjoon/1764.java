import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        List<String> human = new ArrayList<>();
        TreeSet<String> answerList = new TreeSet<>();

        for(int i=0; i<N; i++){
            String name = br.readLine();
            set1.add(name);
            human.add(name);
        }
        for(int i=0; i<M; i++){
            String name = br.readLine();
            set2.add(name);
            human.add(name);
        }

        for(String name : human){
            if(set1.contains(name) && set2.contains(name)){
                answerList.add(name);
            }
        }

        System.out.println(answerList.size());
        for(String ans : answerList){
            System.out.println(ans);
        }
    }
}
