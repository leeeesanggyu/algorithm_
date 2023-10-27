package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n번째 피보나치 수 구하기
public class fibo {

    static int[] memo;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 50;
        memo = new int[n + 1];

        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = fibo(n - 1) + fibo(n - 2);
    }
}

