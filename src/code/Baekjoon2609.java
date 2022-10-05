package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 2609: 최대공약수와 최소공배수
 * https://www.acmicpc.net/problem/2609
 */
public class Baekjoon2609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
//        int num1 = 24;
//        int num2 = 18;

        int 최대공약수 = 최대공약수(num1, num2);
        System.out.println(최대공약수);

        int 최소공배수 = 최소공배수(num1, num2);
        System.out.println(최소공배수);

    }

    private static int 최대공약수(int num1, int num2) {
        int temp = 0;
        int min = Math.min(num1, num2);

        for (int i=1; i<=min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                temp = i;
            }
        }
        return temp;
    }

    private static int 최소공배수(int num1, int num2) {
        int temp = 0;
        int max = Math.max(num1, num2);

        for (int i=1; i<=max; i++) {
            temp = max * i;
            if (temp % Math.min(num1, num2) == 0) {
                return temp;
            }
        }
        return 0;
    }
}