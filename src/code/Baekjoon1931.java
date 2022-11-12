package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 - 1931: 회의실 배정 - greedy
 * https://www.acmicpc.net/problem/1931
 */
public class Baekjoon1931 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meeting = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.deepToString(meeting));

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
//        System.out.println(Arrays.deepToString(meeting));

        int endTime = 0;
        int answer = 0;
        for (int[] el : meeting) {
            if (endTime <= el[0]) {
                endTime = el[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
