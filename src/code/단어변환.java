package code;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static class Node {
        String next;
        int count;

        public Node(String next, int count) {
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
        int n = words.length, ans = 0;
        boolean[] visit = new boolean[n];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {  // 정답 도출
                ans = cur.count;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && checkString(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.count + 1));
                }
            }
        }
        return ans;

    }
}