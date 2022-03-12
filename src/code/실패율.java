package code;

import java.util.Arrays;

public class 실패율 {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    private static int[] solution(int N, int[] stages) {
        int[] check = new int[N]; // 1단계의 값을 저장할 배열
        double[] rate = new double[N]; // 2단계의 실패율을 저장할 배열
        int[] answer = new int[N];

        /*
         * [1] N까지의 자연수에 대응되는 값의 갯수
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i + 1) {
                    check[i]++;
                }
            }
        }

        /*
         * [2] 실패율을 구하는 곳
         */
        int denominator = stages.length;
        for (int i = 0; i < check.length; i++) {
            int numerator = check[i];
            if (denominator == 0) {
                rate[i] = 0;
            } else {
                rate[i] = (double) numerator / denominator;
            }
            denominator -= check[i];
        }
        System.out.println("rate : " + Arrays.toString(rate));


        /*
         * [3] answer을 구한다 (selection sort 방법 이용)
         */
        double max = 0;
        int target = 1;
        for (int i = 0; i < rate.length; i++) {
            max = rate[0];
            target = 1;
            for (int j = 0; j < rate.length; j++) {
                if (rate[j] > max) {
                    max = rate[j];
                    target = j + 1;
                }
            }
            rate[target - 1] = -1;
            answer[i] = target;
        }

        System.out.println("check : " + Arrays.toString(check));
        return answer;
    }
}