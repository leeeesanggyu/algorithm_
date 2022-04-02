package code;

import java.util.HashMap;
import java.util.Map;

public class kakao_문자열압축 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    // 15 / 2 == 7
    // abcabc abcabc dedede dedede
    private static Integer solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String prev = s.substring(0, i);
            int count = 1;
            String enc = "";
            String last = "";
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if (prev.equals(s.substring(j, j + i))) {
                    count++;
                } else {
                    enc += prev;
                    if (count != 1) {
                        enc = count + enc;
                    }
                    prev = s.substring(j, j + i);
                    count = 1;
                }
            }
            enc += prev + last;
            if (count != 1) {
                enc = count + enc;
            }

            answer = Math.min(answer, enc.length());
        }

        return answer;
    }
}