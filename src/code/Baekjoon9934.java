package code;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 - 9934번: 완전 이진 트리
 * https://www.acmicpc.net/problem/9934
 */
public class Baekjoon9934 {

    static Integer K;
    static StringBuffer[] ans;
    static int[] building;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        building = new int[(int) Math.pow(2, K) - 1];
//        System.out.println(Arrays.toString(building));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<building.length; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(building));

        ans = new StringBuffer[K];
        for (int i = 0; i < K; i++) {
            ans[i] = new StringBuffer();
        }

        int floor = 0;
        preOrder(0, building.length - 1, floor);
        for (int i = 0; i < K; i++)
            bw.write(ans[i].toString() + "\n");
        bw.flush();
    }

    private static void preOrder(int start, int end, int floor) {
        if (floor == K) {
            return;
        }

        int middle = (start + end) / 2;
//        System.out.println("middle : " + middle + ", floor : " + floor);
        ans[floor].append(building[middle] + " ");

        preOrder(start, middle - 1, floor + 1);
        preOrder(middle + 1, end, floor + 1);
    }
}