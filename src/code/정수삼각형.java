package code;

import java.util.Arrays;

public class 정수삼각형 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    private static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i=1; i<triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];

            for(int j=1; j<i+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int[] arr = dp[dp.length-1];
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}