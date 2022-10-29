package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 11653: 소인수분해
 * https://www.acmicpc.net/problem/11653
 */
public class Baekjoon11653 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int temp = 2;
        while (N > 1) {
            if (N % temp == 0) {
                N = N / temp;
                System.out.println(temp);
                temp = 1;
            }
            temp++;
        }
    }
}

