package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 10799: 쇠막대기
 * https://www.acmicpc.net/problem/10799
 */
public class Baekjoon10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n.length(); i++) {
            if (n.charAt(i) == '(') {   // (
                stack.push('(');
            } else {                    // )
                if (n.charAt(i - 1) == '(') {      // 레이저
                    stack.pop();
                    answer += stack.size();
                }
                else if (n.charAt(i - 1) == ')') { // 쇠막대 끝
                    stack.pop();
                    answer += 1;
                }

            }
            System.out.println("i :" + i + ", " + n.charAt(i));
            System.out.println("stack :" + stack);
            System.out.println("answer:" + answer);
            System.out.println("-----------------------------");
        }
        System.out.println("answer:" + answer);
    }
}