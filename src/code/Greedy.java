package code;

/**
 * 이코테 - 1이 될때까지
 */
public class Greedy {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(25, 5));
    }

    public static int solution(int N, int K) throws Exception {
        int count = 0;

        while(N > 1) {
            if((N % K) == 0) {
                N = N / K;
            }
            else {
                N -= 1;
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
}



