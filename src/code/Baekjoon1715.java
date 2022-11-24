package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 - 1715: 카드 정렬하기 - greedy
 * https://www.acmicpc.net/problem/1715
 */
public class Baekjoon1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> card = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            card.add(Long.valueOf(br.readLine()));
        }
//        System.out.println(card);

        long answer = 0L;
        while(card.size() > 1) {
            Long one = card.poll();
            Long two = card.poll();
            Long temp = one + two;
            answer += temp;
            card.add(temp);
        }
        System.out.println(answer);
    }
}

