package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 2141: 우체국 - greedy
 * https://www.acmicpc.net/problem/2141
 */
public class Baekjoon2141 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 3  5  3
        // 1  2  3
        int N = Integer.parseInt(br.readLine());

        long sum = 0L;
        long[][] village = new long[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            village[i][0] = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            village[i][1] = A;
            sum += A;
        }
        Arrays.sort(village, ((o1, o2) -> (int) (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0])));
//        System.out.println(Arrays.deepToString(village));
//        System.out.println(sum);

        long temp = 0L;
        for (int i=0; i<N; i++) {
            temp += village[i][1];

            if ((sum + 1) / 2 <= temp) {
//                System.out.println("sum / 2 : " + sum / 2);
//                System.out.println("temp : " + temp);
                System.out.println(village[i][0]);
                break;
            }
        }
    }
}

