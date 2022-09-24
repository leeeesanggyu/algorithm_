package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 1068번: 트리
 * https://www.acmicpc.net/problem/1068
 */
public class Baekjoon1068 {

    static int N, deleteNode, root;
    static ArrayList<Integer>[] graph;
    static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        leaf = new int[N];

        graph = new ArrayList[N];
        for (int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;                   // 루트는 부모가 없으니 -1로 주어집니다..
            } else {
                graph[parent].add(i);       // 각 노드의 자식들
            }
        }
        System.out.println(Arrays.toString(graph));

        // 그래프 지울 노드를 삭제합니다.
        deleteNode = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            graph[i].removeIf(el -> el == deleteNode);
        }
        System.out.println(Arrays.toString(graph));

        if (deleteNode != root) {
            DFS(root, -1);      // 루트를 지운다면 탐색할 필요가 없습니다.
        }
        System.out.println(leaf[root]);
    }

    public static void DFS(int x, int parent) {
        if (graph[x].isEmpty()) {
            leaf[x] = 1;    // 자식이 없다면 그 노드는 리프 노드 입니다.
        }

        for (int y: graph[x]) {
            if (y == parent) {
                continue;   // 위에서 내려왔으니 부모는 볼 필요가 없습니다.
            }
            DFS(y, x);
            leaf[x] += leaf[y];
//            System.out.println("leaf[x] : " + leaf[x]);
        }
    }
}

