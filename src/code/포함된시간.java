package code;

public class 포함된시간 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int hour) {
        int count = 0;

        for(int i=0; i<=hour; i++) {    // 시
            for(int j=0; j<60; j++) {   // 분
                for(int k=0; k<60; k++) {
                    String time = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if(time.contains("3")) count += 1;
                }
            }
        }

        return count;
    }
}
