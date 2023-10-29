package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CodilityTest {
    public static void main(String[] args) throws IOException {
        int[] A = {1, 3, 6, 4, 1, 2};
//        int[] A = {1, 2, 3};
//        int[] A = {-1, -3};

        List<Integer> sortA = Arrays.stream(A)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int temp = 0;
        int answer = sortA.get(sortA.size() - 1) + 1;
        for (int a : sortA) {
            if (sortA.get(sortA.size() - 1) < 0) {
                answer = 1;
                break;
            }

            if (a < 0) {
                continue;
            }

            if (a - temp != 1 && a - temp != 0) {
                answer = a - 1;
                break;
            }

            temp = a;
        }
        System.out.println(answer);
    }
}

