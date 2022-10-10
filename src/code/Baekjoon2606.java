package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 - 2606번: 바이러스
 * https://www.acmicpc.net/problem/2606
 */
public class Baekjoon2606 {
    static int comCount;
    static int comPair;
    static ArrayList<List<Integer>> network;
    static boolean[] isWarm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comCount = Integer.parseInt(br.readLine());
        comPair = Integer.parseInt(br.readLine());

        isWarm = new boolean[comCount + 1];

        network = new ArrayList<>();
        for (int i=0; i<comCount + 1; i++) {
            network.add(new ArrayList<>());
        }

        for (int i=0; i<comPair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network.get(f).add(b);
            network.get(b).add(f);
        }
        System.out.println(network);
        System.out.println(Arrays.toString(isWarm));

        warm(1);
        System.out.println(Arrays.toString(isWarm));

        int answer = 0;
        for(int i=0; i<isWarm.length; i++) {
            if (isWarm[i] == true) {
                answer++;
            }
        }
        System.out.println(answer - 1);
    }
    //

    private static void warm(int com) {
        isWarm[com] = true;
        for (int next: network.get(com)) {
            if (isWarm[next] == false) {
                warm(next);
            }
        }
    }
}

