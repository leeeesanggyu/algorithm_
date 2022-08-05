package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 - 9012번: 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class Baekjoon9012 {
    public static void main(String[] args) throws Exception {
        int count;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        for (int i=0; i<count; i++) {
            String X = br.readLine();

            for (int j = 0; j < X.length(); j++) {
                char c = X.charAt(j);

                if (c == '(') {
                    stack.push(String.valueOf(c));
                } else if (stack.empty()) {
                    stack.push(")");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
        }

    }
}



