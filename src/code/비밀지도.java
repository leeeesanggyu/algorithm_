package code;

import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{9, 1, 21, 17, 28}));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i=0; i<n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i=0; i<n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replace("1", "#");
            result[i] = result[i].replace("0", " ");
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}