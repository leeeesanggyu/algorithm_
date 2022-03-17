package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 네트워크 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private static Integer solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];
        System.out.println(Arrays.toString(check));
        int 답 = 0;

        for(int i=0; i<n; i++) {
            if(!check[i]) {
                깊이우선탐색(computers, check, i);
                답++;
            }
        }
        return 답;
    }

    private static void 깊이우선탐색(int[][] computers, boolean[] check, int i) {
        check[i] = true;

        for(int j=0; j< computers.length; j++) {
            if(computers[i][j] == 1 && !check[j]) {
                깊이우선탐색(computers, check, j);
            }
        }
    }

}