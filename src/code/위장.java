package code;

import java.util.HashMap;

public class 위장 {
    public static void main(String[] args) throws Exception {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) throws Exception {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {    // map에 같은 종류가 있다면 종류 value에 +1
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {    // map에 같은 종류가 없다면 종류와 1 추가
                map.put(clothes[i][1], 1);
            }
        }

        for(int i=0; i<clothes.length; i++) {
            answer *= map.get(clothes[i][1]) + 1;
            map.put(clothes[i][1], 0);
        }

        return answer - 1;
    }

}



