package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 이차원배열영역크기 {
    public static void main(String[] args) throws Exception {
        int[][] office = {{1,0,0,0},{0,0,0,1},{0,0,1,0},{0,1,1,0}};
        int k = 3;
        System.out.println(solution(office, k));
    }

    public static Integer solution(int[][] office, int k) {
//        {
//            {1,0,0,0},
//            {0,0,0,1},
//            {0,0,1,0},
//            {0,1,1,0}
//        }

        int[][] temp = new int[office.length][office.length];

        for (int i=0; i< office.length; i++) {
            for (int j=0; j< office.length-(k-1); j++) {

                for (int l=0; l<k; l++) {
                    temp[i][j] += office[i][j+l];
                }

            }
        }

        for (int i=0; i< office.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        int max = 0;
        for (int i=0; i< office.length-(k-1); i++) {
            for (int j=0; j< office.length; j++) {
                int sum = 0;
                for (int l=0; l<k; l++) {
                    sum += temp[i+l][j];
                    System.out.println(j + ", " + (i+l));
                    System.out.println("office : " + temp[i+l][j]);
                }
                System.out.println("=====================" + sum);
                if(sum > max)
                    max = sum;

            }
        }


        return max;
    }

}
