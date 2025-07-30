import java.util.*;

class Solution {

    public static int [] per= {10,20,30,40};
    public static int[] answer = {0,0};
    public static List<List<Integer>> saleList = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {

        comb(new ArrayList<>(), 0, emoticons.length);

        for(List<Integer> sale : saleList){
            int [] result = calc(users,sale,emoticons);
            if(result[0] > answer[0]){
                answer = result;
            }
            else if(result[0] == answer[0] && result[1] > answer[1]){
                answer = result;
            }
        }



        return answer;
    }

    public void comb(List<Integer> cur, int depth,int length){
        if(depth == length){
            saleList.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<4; i++){
            cur.add(per[i]);
            comb(cur,depth+1,length);
            cur.remove(cur.size() - 1);
        }
    }

    public int[] calc(int[][] users, List<Integer> sale,int[] emoticons){

        int join = 0;
        int profit = 0;

        for(int[] user : users){

            int dis = user[0];
            int maximum = user[1];
            int sum = 0;


            for(int i = 0; i < emoticons.length; i++ ){
                if(dis <= sale.get(i)){
                    sum += (emoticons[i]/100) * (100-sale.get(i));
                }
            }

            if(sum >= maximum){
                join++;
            }
            else{
                profit += sum;
            }
        }
        return new int[] {join,profit};
    }
}