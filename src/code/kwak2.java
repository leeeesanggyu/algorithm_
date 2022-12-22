package code;

import java.util.List;

public class kwak2 {
    public static void main(String[] args) {
//        List<Integer> tree = List.of(3, 9, 20, 0, 0, 15, 7);
        List<Integer> tree = List.of(1, 0, 2);

        int depth = 0;          // 깊이
        int allNodeCount = 1;   // 전체 노드 갯수
        int nodeCount = 1;      // 층의 노드 갯수

        // 2층 = 1층 + (1층 * 2)

        while(allNodeCount <= tree.size()) {
            allNodeCount += nodeCount * 2;
            nodeCount = nodeCount * 2;
            depth++;
        }
        System.out.println(depth);
    }
}
