package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 - 11000: 강의실 배정 - greedy
 * https://www.acmicpc.net/problem/11000
 */
public class Baekjoon11000_timeover {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] clas = new int[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            clas[i][0] = Integer.parseInt(st.nextToken());
            clas[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(clas, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
//        System.out.println(Arrays.deepToString(clas));

        boolean[] check = new boolean[n];
//        System.out.println(Arrays.toString(check));

        int temp = 0;
        int answer = 0;
        boolean whileTrigger = true;

        while (whileTrigger) {
            for (int i=0; i<clas.length; i++) {
                if (check[i] == false && temp <= clas[i][0]) {
                    check[i] = true;
                    temp = clas[i][1];
                }
            }
            answer++;

            for (boolean el : check) {
                if (el == false) {
                    whileTrigger = true;
                    temp = 0;
                    break;
                } else {
                    whileTrigger = false;
                }
            }
        }
        System.out.println(answer);

    }
}

