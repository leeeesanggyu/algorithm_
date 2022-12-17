package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 2839: 설탕 배달 - DP
 * https://www.acmicpc.net/problem/2839
 */
public class Baekjoon2839 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                answer += n / 5;
                break;
            }

            n -= 3;
            answer += 1;

            if (n < 0) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }
}

