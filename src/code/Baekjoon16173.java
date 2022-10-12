package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 - 16173번: 점프왕 쩰리
 * https://www.acmicpc.net/problem/16173
 */
public class Baekjoon16173 {

    static ArrayList<List<Integer>> map;
    static int WALL;
    static String answer = "Hing";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        WALL = n;

        for (int i=0; i<n; i++) {
            map.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map.get(i).add(Integer.valueOf(st.nextToken()));
            }
        }
//        System.out.println(map);

        jump(0, 0);
        System.out.println(answer);
    }

    private static void jump(int x, int y) {
//        System.out.println("x : " + x + ", y : " + y);
        if (map.get(y).get(x) == 0) {
            return;
        }

        if (map.get(y).get(x) == -1) {
            answer = "HaruHaru";
            return;
        }
        if (WALL > x + map.get(y).get(x)) {
            jump(x + map.get(y).get(x), y); // right
        }

        if (WALL > y + map.get(y).get(x)) {
            jump(x, y + map.get(y).get(x)); // down
        }
    }
}

