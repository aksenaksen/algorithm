import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> map = new TreeMap<>();


        for(String ops : operations){
            String[] cmds = ops.split(" ");

            if(cmds[0].equals("I")){
                int num = Integer.parseInt(cmds[1]);
                map.put(num, map.getOrDefault(num, 0) +1);
            }
            else{
                if(map.isEmpty()) continue;

                int num = cmds[1].equals("1") ? map.lastKey() : map.firstKey();
                if(map.get(num) == 1){
                    map.remove(num);
                }
                else{
                    map.put(num,map.get(num)-1);
                }
            }
        }

        if(map.isEmpty()){
            return new int [] {0,0};
        }


        return new int[] {map.lastKey(),map.firstKey()};
    }
}