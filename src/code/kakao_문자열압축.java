package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class kakao_문자열압축 {
    public static void main(String[] args) throws Exception {
        System.out.println("답 :" + solution("ababcdcdababcdcd"));
    }

    private static Integer solution(String s) {
        // aabbaccc
        // 2a 2b a 3c : 7
        int min = Integer.MAX_VALUE;

        //standard 갯수 반복문
        for (int i=1; i<=s.length() / 2 + 1; i++) {
            int cnt = 1;
            StringBuilder sb = new StringBuilder();

            //비교대상 반복문
            String standard = s.substring(0, i);
            for (int j=i; j<s.length(); j+=i) {

                if (j+i > s.length()) {
                    standard = "";
                    sb.append(s, j-i, s.length());
                    break;
                }

                String temp = s.substring(j, j+i);

                if (standard.equals(temp)) {
                    cnt++;
                }
                else {
                    if(cnt != 1) {
                        sb.append(cnt);
                    }
                    cnt = 1;
                    sb.append(standard);
                    standard = s.substring(j, j+i);
                }

            }

            if(cnt != 1) {
                sb.append(cnt);
            }
            sb.append(standard);

            min = (sb.length() < min) ? sb.length() : min;
        }

        return min;
    }

}