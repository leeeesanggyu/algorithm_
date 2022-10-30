package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 - 21919: 소수 최소 공배수
 * https://www.acmicpc.net/problem/21919
 */
public class Baekjoon21919_timeout {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> A = new ArrayList<>();
        for (int i=0; i<N; i++) {
            A.add(Integer.valueOf(st.nextToken()));
        }
        HashSet<Integer> setA = new HashSet<>(A);

        List<Integer> filterA = setA.stream()
                .filter(el -> 소수판독기(el))
                .collect(Collectors.toList());
//        System.out.println(filterA);

        if (filterA.isEmpty()) {
            System.out.println("-1");
            return;
        }
        Integer max = Collections.max(filterA);
        int temp = 1;

        while (true) {
            boolean isAnswer = false;
            for (int el : filterA) {
                if ((max * temp) % el == 0) {
                    isAnswer = true;
                } else {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                System.out.println(max * temp);
                return;
            }

            temp++;
        }
    }

    private static Boolean 소수판독기(int num) {
        int temp = 0;
        for (int i=1; i<=num; i++) {
            if (num % i == 0) {
                temp++;
                if (temp > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}

