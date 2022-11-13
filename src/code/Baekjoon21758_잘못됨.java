package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 21758: 꿀 따기 - Greedy
 * https://www.acmicpc.net/problem/21758
 */
public class Baekjoon21758_잘못됨 {
    static int[] honey;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        honey = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(honey));

        int answer = 0;
        for (int i=1; i<N; i++) {
            int left = getLeft(i);
            int right = getRight(i);

            answer = Math.max(answer, left + right);
        }
        System.out.println(answer);
    }

    private static int getLeft(int index) {
        int temp = 0;
        for (int i=1; i<N; i++) {
            if (i != index) {
                temp += honey[i];
            }
        }
        return temp;
    }
    private static int getRight(int index) {
        int temp = 0;
        for (int i=index + 1; i<N; i++) {
            temp += honey[i];
        }
        return temp;
    }

}

