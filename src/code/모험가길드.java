package code;

import java.util.ArrayList;
import java.util.Collections;

public class 모험가길드 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(6, new int[]{2, 3, 1, 2, 2, 8}));
    }

    public static int solution(int N, int[] scare) {
        ArrayList<Integer> scared = new ArrayList<>();

        for(Integer s : scare) {
            scared.add(s);
        }
        System.out.println(scared);

        Collections.sort(scared, Collections.reverseOrder());
        System.out.println(scared);

        Integer count = 0;
        while (!scared.isEmpty()) {
            Integer master = scared.get(0);

            for(int i=0; i<master; i++){
                try {
                    scared.remove(0);
                }catch (Exception e) {
                    return count;
                }
            }
            count += 1;
        }

        return count;
    }

}
