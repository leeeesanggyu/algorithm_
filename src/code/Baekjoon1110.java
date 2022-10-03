package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 백준 - 1101: 더하기 사이클
 * https://www.acmicpc.net/problem/1101
 */
public class Baekjoon1110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Integer N = Integer.valueOf(br.readLine());
        int N = Integer.parseInt("71");

        int temp = N;
        int count = 0;
        while (true) {
            temp = makeNewNum(temp);
            count++;
            if (temp == N) {
                System.out.println(count);
                break;
            }
        }
    }

    private static int makeNewNum(int temp) {
        int f = (temp / 10);
        int b = (temp % 10);
        int nextF = b * 10;
        temp = nextF + ((f + b) % 10);
        return temp;
    }
}