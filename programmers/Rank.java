import java.util.*;

class People{

    int num;
    Set<Integer> win;
    Set<Integer> lose;

    public People(int num){
        this.num = num;
        this.win = new HashSet<>();
        this.lose = new HashSet<>();
    }
}

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        People [] peoples = new People[n+1];

        for(int i=1; i<=n; i++){
            peoples[i] = new People(i);
        }

        for(int[] result: results){

            peoples[result[0]].lose.add(result[1]);
            peoples[result[1]].win.add(result[0]);
        }


        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(peoples[i].win.contains(k) && peoples[k].win.contains(j)){
                        peoples[i].win.add(j);
                        peoples[j].lose.add(i);
                    }
                    if(peoples[i].lose.contains(k) && peoples[k].lose.contains(j)){
                        peoples[i].lose.add(j);
                        peoples[j].win.add(i);
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(peoples[i].win.size() + peoples[i].lose.size() == n-1){
                answer++;
            }
        }


        return answer;
    }
}