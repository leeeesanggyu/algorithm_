package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 2493번: 탑
 * https://www.acmicpc.net/problem/2493
 */
public class Baekjoon2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stt = new StringTokenizer(br.readLine());

        Stack<Top> stack = new Stack<>();

        for (int i=1; i<=N; i++) {
            int topHeight = Integer.parseInt(stt.nextToken());

            while (!stack.empty()) {
                if (stack.peek().height >= topHeight) {
                    System.out.print(i == N ?stack.peek().index :stack.peek().index + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.empty()) {
                System.out.print(i == N ?"0" :"0 ");
            }

            stack.add(new Top(i, topHeight));
        }
    }

    static class Top {
        int index;
        int height;
        
        Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}