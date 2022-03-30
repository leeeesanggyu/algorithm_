package code;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static class Node {
        private String next;
        private Integer count;

        private Node(String next, Integer count) {
            this.next = next;
            this.count = count;
        }
    }

    private static boolean checkString(String a, String b) {
        int temp = 0;

        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                temp++;
        }

        return (temp == 1)?true :false;
    }

    //solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})
    private static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.next.equals(target)) {  // 정답도출
                answer = node.count;
                break;
            }

            for(int i=0; i<words.length; i++) {
                if(checkString(node.next, words[i]) && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(words[i], node.count + 1));
                }
            }

        }
        return answer;
    }
}