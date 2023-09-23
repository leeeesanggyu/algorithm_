package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 - 13549: 숨바꼭질 3 - BFS
 * https://www.acmicpc.net/problem/13549
 */
/**
 * 수빈이는 동생과 숨바꼭질을 하고 있다.
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 *
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
public class Baekjoon13549 {

    static int[] memo = new int[101];
    static Queue<Node> queue = new LinkedList<>();
    static int N;
    static int K;
    static int MAX_SIZE = 100;
    static int MIN_SIZE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(N + ", " + K);

        System.out.println(Arrays.toString(memo));
        bfs(N);
        System.out.println(Arrays.toString(memo));
        System.out.println(memo[K] - 1);

    }

    // 5, 17 : 2
    public static void bfs(int index) {
        queue.add(new Node(index, 1));
        memo[index] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("now node : " + node);

            if (node.index + 1 < MAX_SIZE && node.index + 1 > MIN_SIZE) {
                if (memo[node.index + 1] == 0 || memo[node.index + 1] > node.time + 1) {
                    queue.add(new Node(node.index + 1, node.time + 1));
                    memo[node.index + 1] = node.time + 1;
                }
            }

            if (node.index - 1 < MAX_SIZE && node.index - 1 > MIN_SIZE) {
                if (memo[node.index - 1] == 0 || memo[node.index - 1] > node.time + 1) {
                    queue.add(new Node(node.index - 1, node.time + 1));
                    memo[node.index - 1] = node.time + 1;
                }
            }

            if (node.index * 2 < MAX_SIZE && node.index * 2 > MIN_SIZE) {
                if (memo[node.index * 2] == 0 || memo[node.index * 2] > node.time) {
                    queue.add(new Node(node.index * 2, node.time));
                    memo[node.index * 2] = node.time;
                }
            }
        }

    }

    public static class Node {
        private int index;
        private int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }
    }
}

