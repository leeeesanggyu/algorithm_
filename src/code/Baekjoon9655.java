package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 9655: 돌 게임 - dp
 * https://www.acmicpc.net/problem/9655
 */
public class Baekjoon9655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int 나머지 = 0;
        if (n > 6) {
            나머지 = n % 6;
        } else {
            나머지 = n;
        }

        if (나머지 % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}

