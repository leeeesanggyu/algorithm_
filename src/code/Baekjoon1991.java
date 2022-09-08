package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 - 1991: 트리 순회
 * https://www.acmicpc.net/problem/1991
 */
public class Baekjoon1991 {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<n+1; i++) {
            String[] line = br.readLine().split(" ");
            int data = line[0].charAt(0) - 65;
            int left = line[1].charAt(0) - 65;
            int right = line[2].charAt(0) - 65;

            list[data].add(new Node(left, right));
        }
        System.out.println(Arrays.toString(list));

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb.toString());

    }

    // 전위 순회 root > left > right
    static void preorder(int start) {
        for(Node node : list[start]) {
//            System.out.println("node => " + start + ", " + node.left + ", " + node.right);
            int l = node.left;
            int r = node.right;

            sb.append((char)(start + 65));
            if(l != -19) preorder(l);
            if(r != -19) preorder(r);
        }
    }

    // 중위 순회 left > root > right
    static void inorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -19) inorder(l);
            sb.append((char)(start + 65));
            if(r != -19) inorder(r);
        }
    }

    // 후위 순회 left > right > root
    static void postorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -19) postorder(l);
            if(r != -19) postorder(r);
            sb.append((char)(start + 65));
        }
    }
}