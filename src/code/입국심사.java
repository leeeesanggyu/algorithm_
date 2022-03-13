package code;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(6, new int[]{3, 3, 3, 3}));
    }

    public static Long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long min = 0;
        long max = (long)n * times[times.length-1];

        while(min <= max) {
            long mid = (min+max)/2;
            long sum = 0;
            for(int time : times) {
                sum += mid / time;
            }

            if(sum < n) {
                min = mid+1;
            }
            else {
                max = mid-1;
                answer = mid;
            }
        }
        System.out.println("min : " + min + "max : " + max);
        return answer;
    }
}
