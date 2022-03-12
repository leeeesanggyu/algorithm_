package code;

//Bottom -> Up
public class 피보나치수열 {

    private static Long[] dp = new Long[100];

    public static void main(String[] args) throws Exception {
        System.out.println(fibonacci(50));
    }

    private static Long fibonacci(int number) {
        dp[1] = 1L;
        dp[2] = 1L;
        for(int i=3; i<=number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number];
    }

}
