package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 가장_큰_수 {

    public static void main(String[] args) throws Exception {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        System.out.println(list);

        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a); // String 34
            String bs = String.valueOf(b); // String 5
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as)); //345, 534
        });

        System.out.println(list);

        StringBuilder sb = new StringBuilder();

        for(Integer i : list) {
            sb.append(i);
        }

        return sb.toString().charAt(0) == ('0') ? "0" : sb.toString();
    }

}
