package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 123: example - example
 * https://www.acmicpc.net/problem/123
 */
public class Baekjoon1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10;
//        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
//        dp[0] = 0;
//        dp[1] = 0;

        int result = calculate(N);
        System.out.println(result);
    }

    public static int calculate(int number){
        if (number == 1) {
            return dp[number];
        }

        if (dp[number] > 0) {
            return dp[number];
        }

        dp[number] = calculate(number - 1);

        if (number % 3 == 0) {
            dp[number] = Math.min(calculate(number / 3), dp[number]) + 1;
        } else if (number % 2 == 0) {
            dp[number] = Math.min(calculate(number / 2), dp[number]) + 1;
        }
        return dp[number];
    }
}

