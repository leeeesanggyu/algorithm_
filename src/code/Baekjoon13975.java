package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 13975: 파일 합치기 3 - Greedy
 * https://www.acmicpc.net/problem/13975
 */
public class Baekjoon13975 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i=0; i<K; i++) {
                pq.add(Long.valueOf(st.nextToken()));
            }
//        System.out.println(pq);

            Long answer = 0L;
            while (pq.size() > 1) {
                Long one = pq.poll();
                Long two = pq.poll();
                Long sum = one + two;
                answer = answer + sum;
//            System.out.println("answer : " + answer);
                pq.add(sum);
            }
            System.out.println(answer);
        }

    }
}

