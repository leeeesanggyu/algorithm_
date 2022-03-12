package code;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선큐 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
    }

    private static int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());

        for(var i: operations) {
            String[] s = i.split(" ");
            System.out.println(s[0] + s[1]);

            if (s[0].equals("I")) {
                pq.offer(Integer.valueOf(s[1]));
                rpq.offer(Integer.valueOf(s[1]));
            }

            if (s[0].equals("D") && s[1].equals("-1")) {
                Integer poll = pq.poll();
                rpq.remove(poll);
            }

            if (s[0].equals("D") && s[1].equals("1")) {
                Integer poll = rpq.poll();
                pq.remove(poll);
            }
        }


        if (pq.isEmpty()) return new int[]{0, 0};

        return new int[]{rpq.peek(), pq.peek()};
    }
}
