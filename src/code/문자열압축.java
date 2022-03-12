package code;

import java.util.HashMap;
import java.util.Map;

/* 문자열 압축
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시
오. 단 반복횟수가 1인 경우 생략합니다.
▣ 입력설명
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
▣ 출력설명
첫 줄에 압축된 문자열을 출력한다.
▣ 입력예제 1
KKHSSSSSSSE
▣ 출력예제 1
K2HS7E */
public class 문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("ADSDD"));
    }

    public static String solution(String ex) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<ex.length(); i++) {
            if (!map.containsKey(String.valueOf(ex.charAt(i)))) {
                map.put(String.valueOf(ex.charAt(i)), 1);
            }
            else {
                map.put(String.valueOf(ex.charAt(i)), map.get(String.valueOf(ex.charAt(i))) + 1);
            }
        }
        System.out.println(map);

        String _ex = "";
        for (int i = 0; i < ex.length(); i++) {
            if(ex.indexOf(ex.charAt(i)) == i) {
                _ex += ex.charAt(i);
            }
        }
        System.out.println(_ex);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < _ex.length(); i++) {
            sb.append(_ex.charAt(i));
            if(map.get(String.valueOf(_ex.charAt(i))) != 1) {
                sb.append(map.get(String.valueOf(_ex.charAt(i))));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

}



