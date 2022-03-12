package code;

import java.util.Arrays;

public class H_index {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

    public static int solution(int[] citations) throws Exception {
        Arrays.sort(citations);

        int count = 0;
        for(int i=citations.length - 1; i>=0; i--) {
            if(citations[i] <= count) {
                return count;
            }
            count++;
        }
        return -1;
    }
}



