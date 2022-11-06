package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 - 13164: 행복 유치원 - greedy
 * https://www.acmicpc.net/problem/13164
 *
 * 오름 차순 정렬 후 인접해 있는 것의 차 가 제일 효율적이므로 차 를 구한다.
 * 그리고 다시 오름차순으로 정렬해 차가 적은 효율적인 인접한 차를 더한다.
 */
public class Baekjoon13164 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            students[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(students);
//        System.out.println(Arrays.toString(students));

        int[] 인접비용차 = new int[n - 1];
        for (int i=0; i<n-1; i++) {
            인접비용차[i] = students[i + 1] - students[i];
        }
        Arrays.sort(인접비용차);
//        System.out.println(Arrays.toString(인접비용차));

        int answer = 0;
        for (int i=0; i<n-k; i++) {
//            System.out.println("i : " + i);
            answer += 인접비용차[i];
        }
        System.out.println(answer);
    }

//    1조: 1, 3
//    2조: 5, 6
//    3조: 10

//    1, 2, 2, 4
}

