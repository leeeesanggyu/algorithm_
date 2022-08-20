package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 2346번: 풍선 터뜨리기
 * https://www.acmicpc.net/problem/2346
 */
public class Baekjoon2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] balloon = br.readLine().split(" ");

        Deque<Balloon> deq = makeDeq(N, balloon);
        List<Integer> answer = logic(deq);
        makeAnswer(answer);
    }

    private static List<Integer> logic(Deque<Balloon> deq) {
        List<Integer> answer = new ArrayList<>();
        while(deq.size() > 1) {
            Balloon cur = deq.poll();
            answer.add(cur.idx);

            int move = cur.num;
            if(move < 0) {
                while(move++ < 0)
                    deq.addFirst(deq.pollLast());
            } else {
                move--;
                while(move-- > 0)
                    deq.addLast(deq.pollFirst());
            }
        }
        answer.add(deq.poll().idx);
        return answer;
    }

    private static Deque<Balloon> makeDeq(int N, String[] balloon) {
        List<Integer> balloonList = new ArrayList<>();
        Arrays.stream(balloon).forEach(el -> balloonList.add(Integer.parseInt(el)));

        Deque<Balloon> deq = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            deq.add(new Balloon(i + 1, balloonList.get(i)));
        }
        return deq;
    }

    private static void makeAnswer(List<Integer> answer) {
        StringBuilder sb = new StringBuilder();
        for (int el: answer) {
            sb.append(el).append(" ");
        }
        String realAnswer = sb.toString();
        System.out.println(realAnswer.substring(0, realAnswer.length() - 1));
    }

    static class Balloon {
        int idx, num;

        Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}