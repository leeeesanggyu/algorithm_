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
public class Baekjoon21758 {
    static int[] honey;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //  꿀통의 개수N
        int[] honey = new int[N+1];
        int[] sum = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = honey[i]+ sum[i-1];
        }
        System.out.println(Arrays.toString(honey));
        System.out.println(Arrays.toString(sum));

        int ans = 0;

        //벌 벌 벌통
        for(int i=2; i<=N-1; i++) {
            int tmp = sum[N] - honey[1] - honey[i] + sum[N] - sum[i];
            ans = Math.max(ans, tmp);
        }

        //벌 벌통 벌
        for(int i=2; i<=N-1; i++) {
            int tmp = sum[N-1] - sum[i-1] + sum[i] - sum[1];
                    // 36 - 9 + 18 - 9
            ans = Math.max(ans, tmp);
        }

        //벌통 벌 벌
        for(int i=2; i<=N-1; i++) {
            int tmp = sum[N-1] - honey[i] + sum[i-1];
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
}

