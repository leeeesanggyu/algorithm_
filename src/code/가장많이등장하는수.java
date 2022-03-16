package code;

import java.util.Arrays;
import java.util.HashMap;

public class 가장많이등장하는수 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{1, 0, 4, 0, 1, 1, 6, 6, 6, 6, 6}));
    }

    private static Integer solution(int[] s) {
        int[] answer = new int[s.length];
        int dap = 0;

        for(int i=0; i<s.length; i++) {
            answer[s[i]] += 1;
        }
        System.out.println(Arrays.toString(answer));

        for(int i=0; i<s.length; i++) {
            if(answer[dap] < answer[i]) {
                dap = i;
            }
        }
        return dap;
    }
}