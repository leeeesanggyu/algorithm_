package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 1010: 다리 놓기 - dp
 * https://www.acmicpc.net/problem/1010
 */
public class Baekjoon1010 {

    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            dp = new int[right + 1][left + 1];

            int result = combi(right, left);
            System.out.println(result);
        }
    }

    static int combi(int n, int r) {
        if (n == r || r == 0) { // 재귀 탈출
            return 1;
        }

        if (dp[n][r] > 0) {     // 메모이제이션
            return dp[n][r];
        }

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}

