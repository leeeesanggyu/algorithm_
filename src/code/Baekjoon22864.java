package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 22864: 피로도
 * https://www.acmicpc.net/problem/22864
 */
public class Baekjoon22864 {

    static int hour = 0;
    static int work = 0;
    static int pirodo = 0;

    static int A;
    static int B;
    static int C;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 피로도 1시간 A만큼 쌓이고  = 5
        // 최대 피로도 M           = 10
        // 일 1시간 B만큼 처리      = 3
        // 피로도 1시간 C만큼 줄어듬  = 2

        // 24시간 동안 일 얼만큼 할 수 있나
        // 일  6   6   6   6
        //시간  2 5 2 5 2 5 2

        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);
        M = Integer.parseInt(input[3]);

        while (hour < 24) {
//            System.out.println("pirodo =>" + pirodo);
            if (pirodo + A <= M) {
                work();
            } else {
                rest();
            }
            hour++;
        }
        System.out.println(work);
    }

    private static void work() {
        pirodo += A;
        work += B;
    }

    private static void rest() {
        pirodo -= C;
        if (pirodo < 0) {
            pirodo = 0;
        }
    }
}

