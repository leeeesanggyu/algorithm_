package code;

// TODO visited 써야됨
public class 개구리점프DFS {
    public static void main(String[] args) throws Exception {
        int[] nums = {4, 1, 2, 3, 1, 0, 5};
        System.out.println(solution(nums));
    }

    public static Integer solution(int[] nums) {
        int count = 0;
        return dfs(0, count, nums);
    }

    private static int dfs(int idx, int count, int[] nums) {
        if(count > nums.length) // 무한점프 방지
            return -1;

        if(idx == nums.length-1)    // 정답 도출
            return count;

        int lhsResult = -1;
        int lhsIdx = idx - nums[idx];
        if(lhsIdx > 0)
            lhsResult = dfs(lhsIdx, count+1, nums);

        int rhsResult = -1;
        int rhsIdx = idx + nums[idx];
        if(rhsIdx < nums.length)
            rhsResult = dfs(rhsIdx, count+1, nums);

        if(lhsResult == -1)
            return rhsResult;

        if(rhsResult == -1)
            return lhsResult;

        return Math.min(rhsResult, lhsResult);
    }

}
