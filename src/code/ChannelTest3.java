package code;

import java.util.Arrays;
import java.util.LinkedList;

public class ChannelTest3 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }

    public static int solution(int[][] L) throws Exception {
        Arrays.sort(L, (x, y) -> {
            if (x[1] != 0) return 1;
            if (y[1] != 0) return -1;
            return x[0] - y[0];
        });
        System.out.println(Arrays.deepToString(L));



        return 1;
    }
}

