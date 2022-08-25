package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 2504번: 괄호의 값
 * https://www.acmicpc.net/problem/2504
 */
public class Baekjoon2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] split = n.split("");

        List<String> nList = Arrays.asList(split);

        Stack<String> stack = new Stack<>();
        Integer temp = 1;
        Integer answer = 0;

        for(int i = 0; i < nList.size(); i++) {
            if(nList.get(i).equals("(")) {
                stack.push(nList.get(i));
                temp *= 2;
            } else if(nList.get(i).equals("[")) {
                stack.push(nList.get(i));
                temp *= 3;
            } else if(nList.get(i).equals(")")) {
                if(stack.isEmpty() || !stack.peek().equals("(")) {
                    answer = 0;
                    break;
                } else if(nList.get(i - 1).equals("(")) {
                    answer += temp;
                }
                stack.pop();
                temp /= 2;
            } else if(nList.get(i).equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    answer = 0;
                    break;
                } else if (nList.get(i - 1).equals("[")) {
                    answer += temp;
                }
                stack.pop();
                temp /= 3;
            }
            log(nList.get(i), temp, stack, answer);
        }
        StringBuilder sb = new StringBuilder();
        if(!stack.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(answer);
        }
        System.out.println(sb);
    }

    private static void log(String now, Integer temp, Stack stack, Integer answer) {
        System.out.println("now  : " + now);
        System.out.println("temp : " + temp);
        System.out.println("stack: " + stack);
        System.out.println("answe: " + answer);
        System.out.println("====================");
    }
}