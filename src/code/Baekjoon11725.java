package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 11725: 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 *
 * 첫 루트 노드에서부터
 * 해당 노드가 누구의 부모 노드인가 찾는것이 핵심
 */
public class Baekjoon11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N + 1; i++) {
            graph.add(new ArrayList<>());
        }
//        System.out.println(graph);

        for (int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
//        System.out.println(graph);

        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;
//        System.out.println("q : " + q);
//        System.out.println("visited : " + Arrays.toString(visited));
        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int el: graph.get(poll)) {
//                System.out.println("el : " + el);
                if (!visited[el]) {
                    visited[el] = true;
                    parent[el] = poll;
                    q.add(el);
                }
            }

        }
//        System.out.println("parent : " + Arrays.toString(parent));
        for (int i=2; i< parent.length; i++) {
            System.out.println(parent[i]);
        }


    }
}