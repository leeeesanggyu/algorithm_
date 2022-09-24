package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 5618: 공약수
 * https://www.acmicpc.net/problem/5618
 */
public class Baekjoon5618 {

    static boolean is = true;
    static int temp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i=0; i<n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        System.out.println(nums);

        while (nums.get(0) >= temp) {
            is = nums.stream().anyMatch(e ->
                    e % temp != 0
            );
            if (is == false) {
                System.out.println(temp);
            }
            is = true;
            temp++;
        }
    }
}

