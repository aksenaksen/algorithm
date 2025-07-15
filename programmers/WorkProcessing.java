import java.util.*;

class Solution {
    class Work{
        String name;
        int start;
        int remain;

        public Work(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }

    }

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Work> pq = new PriorityQueue<>((a,b) -> a.start-b.start);

        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int hour = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int remain = Integer.parseInt(plan[2]);
            Work work = new Work(plan[0], hour, remain);
            pq.add(work);
        }

        Stack<Work> stack = new Stack<>();
        int curTime = 0;

        while (!pq.isEmpty()) {
            Work cur = pq.poll();
            curTime = Math.max(curTime, cur.start);

            int nextStart = pq.isEmpty() ? Integer.MAX_VALUE : pq.peek().start;

            if (curTime + cur.remain <= nextStart) {
                curTime += cur.remain;
                answer.add(cur.name);

                while (!stack.isEmpty() && curTime < nextStart) {
                    Work pausedTask = stack.pop();

                    if (curTime + pausedTask.remain <= nextStart) {
                        curTime += pausedTask.remain;
                        answer.add(pausedTask.name);
                    } else {
                        pausedTask.remain -= (nextStart - curTime);
                        curTime = nextStart;
                        stack.push(pausedTask);
                        break;
                    }
                }

            } else {
                cur.remain -= (nextStart - curTime);
                curTime = nextStart;
                stack.push(cur);
            }
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }
}