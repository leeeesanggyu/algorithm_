package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 - 2812: 크게 만들기 - Greedy
 * https://www.acmicpc.net/problem/2812
 */
public class Baekjoon2812 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
//        System.out.println(num);
        String[] splitNum = num.split("");
        ArrayList<Integer> numList = new ArrayList<>();
        for (String el : splitNum) {
            numList.add(Integer.valueOf(el));
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(numList.get(0));
//        System.out.println("stack : " + stack);

        int KTemp = 0;
        for (int i=1; i<numList.size(); i++) {
            while (!stack.isEmpty() && stack.peek() < numList.get(i) && KTemp < K) {
                stack.pop();
                KTemp++;
            }
            stack.add(numList.get(i));
//            System.out.println("stack : " + stack);
        }

//        6 4
//        198794
        for(int i = 0; i < numList.size() - K; i++) {
            System.out.print(stack.get(i));
        }
    }
}

