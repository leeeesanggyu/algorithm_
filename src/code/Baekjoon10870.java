package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 10870: 피보나치 수 5 - dp
 * https://www.acmicpc.net/problem/10870
 */
public class Baekjoon10870 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 점화식 f(n) = f(n-1) + f(n-2)

        int result = fibonacci(n);
        System.out.println(result);
    }

    public static int fibonacci(int n) {
        if (n == 0) return n;
        if (n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

