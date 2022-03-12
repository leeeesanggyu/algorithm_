package code;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) throws Exception {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(var p: participant) {
            var val = map.get(p);
            if(val == null)
                val = 0;

            map.put(p, val+1);
        }

        for(var c: completion) {
            map.put(c, map.get(c) - 1);
        }

        for(var p: participant) {
            if(map.get(p) == 1) {
                return p;
            }
        }

        return answer;
    }
}



