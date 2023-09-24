package code.oh;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class oh4 {

    public static void main(String[] args) {
        int[] references = {3, 2, 0, 4, 8};
        int result = solution(references);
        System.out.println(result);
    }

    // 0x 2x 3 4 8
    // 8 5 3 2 0
    // n : 논문 갯수
    // k : 인용 횟수

    //TODO 개선사항 정렬 거꾸로 했을꺼같다.
    private static int solution(int[] references) {
        final int n = references.length;
        Arrays.sort(references);

        int result = -1;

        for(int i = 0; i < n; i++) {
            final int k = references[i];

            if( k > (references.length - i)){
                continue;
            }

            // 다른 n-k개의 논문은 각각 K개의 인용 횟수를 넘지 않아야 합니다.
            if( n - k > i + 1 ) {
                continue;
            }

            result = Math.max(result, references[i]);
        }
        return result;
    }
}

