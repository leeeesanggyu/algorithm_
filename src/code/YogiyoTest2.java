package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class YogiyoTest2 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{1, 2, 1}));
    }

    public static Integer solution(int[] a) throws Exception {
        int answer = 0;
        final List<Integer> sortA = sortIntArray(a);

        int location = 1;
        for (int elementA: sortA) {
            if (elementA != location)
                answer += gap(elementA, location);

            location++;
        }
        return answer;
    }

    // 차이가 양수 음수 구분하지 않기 위해 gap을 구합니다.
    private static int gap(int elementA, int location) {
        int temp = elementA - location;
        if (temp < 0)
            return temp * -1;
        return temp;
    }

    // array -> ArrayList 후 sort 합니다.
    private static List<Integer> sortIntArray(int[] a) {
        ArrayList<Integer> sortA = new ArrayList<>();

        for (int intergerA: a)
            sortA.add(intergerA);

        Collections.sort(sortA);
        return sortA;
    }
}



