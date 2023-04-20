package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class inter {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String s = "abababab";
        System.out.println(findShortString(s).length());
    }

    public static String findShortString(String s) {
        int n = s.length();
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)    // 1, 2, 4, 8
                .mapToObj(i -> s.substring(0, i)) // a, ab, abab, abababab
                .filter(pattern -> s.matches("(" + pattern + ")+"))
                .findFirst()
                .orElse(s);
    }
}

