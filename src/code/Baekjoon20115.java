package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 20115: 에너지 드링크 - Greedy
 * https://www.acmicpc.net/problem/20115
 */
public class Baekjoon20115 {

//    static int[] drink = {3, 2, 10, 9, 6};
//    static int[] drink = {100, 9, 77, 65, 39, 27, 45, 1, 80, 495};
    static int[] drink;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        drink = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drink);
        double maxDrink = drink[N - 1];

        for (int i = 0; i <= N - 2; i++) {
            maxDrink += (double) drink[i] / 2;
        }

        System.out.println(maxDrink);
    }
}