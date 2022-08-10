package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 1158번: 요세푸스
 * https://www.acmicpc.net/problem/1158
 */
public class Baekjoon1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s = input.split(" ");

        int N, K;
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        int temp = 1;

        while(!queue.isEmpty()) {
            if (temp == K) {
                temp = 1;
                answer.add(queue.remove());
            } else {
                temp++;
                queue.offer(queue.remove());
            }
        }

        System.out.println(makeAnswer(answer));
    }

    private static String makeAnswer(List<Integer> answer) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (Integer el: answer) {
            sb.append(el).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        return sb.toString();
    }
}