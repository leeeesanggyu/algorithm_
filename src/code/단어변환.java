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

    private static boolean isNext(String cur, String n) {
        System.out.println("cur : " + cur + " n : " + n);
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }

        return true;
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
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.count + 1));
                }
            }
        }
        return ans;

    }
}
// for (int i=0; i<n; i++)
//  if (words[i] != target && i == n-1) return 0;