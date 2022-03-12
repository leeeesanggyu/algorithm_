package code;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    private static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(var i: scoville) {
            pq.add(i);
        }
        System.out.println("pq : " + pq);

        int count = 1;
        while (pq.peek() < K && pq.peek() != null) {
            Integer i = pq.poll();

            if(pq.peek() == null) {
                count = -1;
                break;
            }
            Integer j = pq.poll();

            int temp = i + (j * 2);
            count ++;
            pq.offer(temp);
        }
        return count;
    }
}
