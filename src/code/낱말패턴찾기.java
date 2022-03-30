package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 낱말패턴찾기 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("가나다가", "바나나 드래곤 스리랑카 스리랑카"));
    }

    private static boolean solution(String p, String s) {
        boolean answer = true;
        String[] split_p = p.split("");
        String[] split_s = s.split(" ");

        Map<String, String> map = new HashMap<>();

        for(int i=0; i< split_p.length; i++) {
            //같은 패턴 체크
            if( map.containsKey(split_p[i]) ) {
                if( !map.get(split_p[i]).equals(split_s[i]) ) {
                    return false;
                }
            }

            //다른 패턴 체크
            if( !map.containsKey(split_p[i]) ) {
                if ( map.containsValue(split_s[i]) ) {
                    return false;
                }
            }
            map.put(split_p[i], split_s[i]);

        }
        return answer;
    }
}