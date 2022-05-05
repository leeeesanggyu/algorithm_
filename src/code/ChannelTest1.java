package code;

public class ChannelTest1 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(3000, 5000, 23000));
    }

    public static int solution(int a, int b, int budget) throws Exception {
        int answer = 0;

        int count = 0;
        while (true) {
            if (a * count > budget) break;

            if ((budget - (a * count)) % b == 0) {
                answer++;
            }
            count++;
        }

        return answer;
    }
}



