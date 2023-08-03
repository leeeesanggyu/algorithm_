package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class zum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = 2; // 원하는 자연수 n을 설정합니다.
        int result = sumQuotientEqualsRemainder(n);
        System.out.println("결과: " + result);
    }

    public static int sumQuotientEqualsRemainder(int n) {
        int sum = 0;
        int num = n + 1;

        while (true) {
            int quotient = num / n;
            int remainder = num % n;

            if (quotient >= n) {
                return sum;
            }

            if (quotient == remainder) {
                sum += num;
            }
            num++;
        }
    }
}

