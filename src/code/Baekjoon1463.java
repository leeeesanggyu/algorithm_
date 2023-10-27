package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 123: example - example
 * https://www.acmicpc.net/problem/123
 */
public class Baekjoon1463 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10;
        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        int result = calculate(N);
        System.out.println(result);
    }

    private static int calculate(int num) {
        if (dp[num] == null) {
            if (num % 6 == 0) {
                dp[num] = Math.min(calculate(num - 1), Math.min(calculate(num / 3), calculate(num / 2))) + 1;
            } else if (num % 3 == 0) {
                dp[num] = Math.min(calculate(num - 1), calculate(num / 3)) + 1;
            } else if (num % 2 == 0) {
                dp[num] = Math.min(calculate(num - 1), calculate(num / 2)) + 1;
            } else {
                dp[num] = calculate(num - 1) + 1;
            }
        }
        return dp[num];
    }
}

