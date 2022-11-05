package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 - 11000: 강의실 배정 - greedy, priority queue
 * https://www.acmicpc.net/problem/11000
 */
public class Baekjoon11000 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] clas = new int[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            clas[i][0] = Integer.parseInt(st.nextToken());
            clas[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(clas, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        System.out.println(Arrays.deepToString(clas));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(clas[0][1]);

        for(int i=1; i<n; i++) {
            if (pq.peek() <= clas[i][0]) {
                pq.poll();
            }
            pq.add(clas[i][1]);
//            System.out.println("pq : " + pq);
        }

//        System.out.println("pq : " + pq);
        System.out.println(pq.size());
    }
}

