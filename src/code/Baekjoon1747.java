package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 1747: 소수&팰린드롬
 * https://www.acmicpc.net/problem/1747
 */
public class Baekjoon1747 {

    static int MAX = 2000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[MAX + 1];
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i=2; (i * i)<isPrime.length; i++) {
            if(isPrime[i] == true) {
                continue;
            }
            for (int j=i*2; j<isPrime.length; j+=i) {
                isPrime[j] = true;
            }
        }

        for (int i=n; i<=MAX; i++) {
            if (isPrime[i] == false && isPelin(i) == true) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean isPelin(int num) {
        String[] stringNum = String.valueOf(num).split("");

        boolean result = true;
        for (int i=0; i<stringNum.length; i++) {
            if (!stringNum[i].equals(stringNum[stringNum.length - 1 - i])) {
                result = false;
            }
        }
        return result;
    }
}

