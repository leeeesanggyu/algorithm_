package code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Rid2 {
    public static void main(String[] args) throws IOException {
        int n = 5; // Example size of the matrix
        int r = 3; // Example row to query
        int c = 2; // Example column to query
        int[][] array = new int[n][n];

        int num = 1;  // 시작 숫자

        // 각 대각선의 인덱스를 따라 숫자 채우기
        for (int k = 0; k < 2 * n - 1; k++) {
            int startRow = k < n
                    ? k
                    : n - 1;
            int startCol = k < n
                    ? 0
                    : k - n + 1;

            while (startRow >= 0 && startCol < n) {
                array[startRow][startCol] = num++;
                startRow--;
                startCol++;
            }
        }

        // 배열 출력
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(array[c - 1][r - 1]);
    }
}