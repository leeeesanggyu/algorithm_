package code;

import java.util.Stack;

/**
 * 두 그룹으로 나눴을 때 합의 차가 제일 적은 결과
 */
public class test2 {
    static int[] arr = {1, 2, 3, 5};
    static int lhs = 0;
    static int rhs = 0;
    static int answer = Integer.MAX_VALUE;

    static Stack<Integer> lhsStack = new Stack<Integer>();
    static Stack<Integer> rhsStack = new Stack<Integer>();

    public static void main (String[] args) {
        dfs(0);
        System.out.println(answer);
    }

    static void dfs (int idx) {
        if(idx == arr.length) {
            int gap = rhs - lhs;
            if(lhs > rhs)
                gap = lhs - rhs;

            if(answer > gap)
                answer = gap;

            return;
        }

        lhs += arr[idx];
        dfs(idx + 1);

        lhs -= arr[idx];
        rhs += arr[idx];

        dfs(idx + 1);
        rhs -= arr[idx];
    }
}
