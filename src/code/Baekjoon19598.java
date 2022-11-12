package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 - 19598: 최소 회의실 개수 - greedy
 * https://www.acmicpc.net/problem/19598
 */
public class Baekjoon19598 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] meeting = new int[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meeting, ((o1, o2) -> o1[0] - o2[0]));
//        System.out.println(Arrays.deepToString(meeting));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meeting[0][1]);

        for (int i=1; i<n; i++) {
            if (pq.peek() <= meeting[i][0]) {
                pq.poll();
            }
            pq.add(meeting[i][1]);
        }
//        System.out.println(pq);
        System.out.println(pq.size());
    }
}

