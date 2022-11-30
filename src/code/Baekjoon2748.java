package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 - 10870: 피보나치 수 2 - dp
 * https://www.acmicpc.net/problem/10870
 */
public class Baekjoon2748 {

    static long[] temp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        temp = new long[n + 1];
        // 점화식 f(n) = f(n-1) + f(n-2)

        long result = fibonacci(n);
        System.out.println(result);
    }

    public static long fibonacci(int n) {
//        System.out.println(Arrays.toString(temp));
        if (n == 0) {
            return n;
        }
        if (n == 1) {
            return n;
        }

        if (temp[n] == 0) {
            temp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return temp[n];
    }
}

