package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 1260: DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class Baekjoon1260 {

    static List<Integer>[] map;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int linkCount = Integer.parseInt(st.nextToken());
        Integer v = Integer.valueOf(st.nextToken());

        dfsVisited = new boolean[nodeCount + 1];
        bfsVisited = new boolean[nodeCount + 1];

        map = new ArrayList[nodeCount + 1];
        for (int i=0; i<nodeCount + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i=0; i<linkCount; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[f].add(b);
            map[b].add(f);
        }

        for (List<Integer> mapEl : map) {
            Collections.sort(mapEl);
        }
//        System.out.println(Arrays.toString(dfsVisited));
//        System.out.println(Arrays.toString(bfsVisited));
        System.out.println(Arrays.toString(map));

        dfs(v);
        System.out.println();
        bfs(v);
    }

    private static void bfs(Integer v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        bfsVisited[v] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");

            for (Integer el: map[poll]) {
                if (!bfsVisited[el]) {
                    bfsVisited[el] = true;
                    queue.add(el);
                }
            }
        }
    }

    private static void dfs(Integer v) {
        System.out.print(v + " ");
        dfsVisited[v] = true;

        for (Integer el: map[v]) {
            if (!dfsVisited[el]) {
                dfs(el);
            }
        }
    }
}

