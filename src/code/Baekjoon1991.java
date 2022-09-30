package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 - 1991번: 트리순회
 * https://www.acmicpc.net/problem/1991
 */
public class Baekjoon1991 {
    public static void main(String[] args) throws Exception {
        // - 65
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());

        ArrayList<ArrayList<Character>> tree = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String[] node = br.readLine().split(" ");
            ArrayList<Character> sonNode = new ArrayList<>();
            sonNode.add(node[1].charAt(0));
            sonNode.add(node[2].charAt(0));
            tree.add(sonNode);
        }
        System.out.println(tree);
        // tree [[B, C], [D, .], [E, F], [., .], [., G], [., .], [., .]]

        Queue<Character> q = new LinkedList<>();
        q.add('A');
        boolean[] visited = new boolean[N];

        while(!q.isEmpty()) {
            Character poll = q.poll();
            int i = poll - 65;
            System.out.println("poll => " + poll);

            if (!visited[i]) {
                visited[i] = true;
                q.add(tree.get(i).get(0));
                q.add(tree.get(i).get(1));
            }


        }
    }
}