package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 20365: 블로그2 - Greedy
 * https://www.acmicpc.net/problem/20365
 */
public class Baekjoon20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
//        int N = 8;
//        String input = "BBBBBRRBBBBBBR";

        String[] splitInput = input.split("");

        int BCount = 0;
        int RCount = 0;
        String lastString = "X";

        for (String inputElement : splitInput) {
            if (inputElement.equals(lastString)) {
                continue;
            }

            if (inputElement.equals("B")) {
                BCount += 1;
                lastString = "B";
            } else {
                RCount += 1;
                lastString = "R";
            }
        }

        if (BCount > RCount) {
            System.out.println(RCount + 1);
        } else {
            System.out.println(BCount + 1);
        }
    }
}

