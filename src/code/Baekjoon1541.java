package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 - 1541: 잃어버린 괄호 - Greedy
 * https://www.acmicpc.net/problem/1541
 */
public class Baekjoon1541 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                final String input = "00009-00009";
//        String input = br.readLine();

        String[] splitMinus = input.split("-");
        System.out.println(Arrays.toString(splitMinus));

        int sum = Integer.MAX_VALUE;

        for (String token : splitMinus) {
            String[] splitToken = token.split("\\+");

            int elementSum = 0;
            for (String element : splitToken) {
                elementSum += Integer.parseInt(element);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = elementSum;
            } else {
                sum -= elementSum;
            }
        }

        System.out.println(sum);
    }
}

