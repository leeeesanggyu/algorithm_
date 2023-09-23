package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class oh4refact {

    public static void main(String[] args) {
        int[] references = {3, 2, 0, 4, 8};
        int result = solution(references);
        System.out.println(result);
    }

    // 0 2 3 4 8
    // 8 5 3 2 0
    // n : 논문 갯수
    // k : 인용 횟수
    private static int solution(int[] references) {
        List<Integer> referenceList = IntStream.of(references).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(referenceList);

        int referencesSize = referenceList.size();

        for (int i = 0; i < referencesSize; i++) {
            if ((i + 1) >= referenceList.get(i)) {
                return referenceList.get(i);
            }
        }
        return -1;
    }
}

