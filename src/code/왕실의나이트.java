package code;

public class 왕실의나이트 {
    public static void main(String[] args) {
        System.out.println(solution("c2"));
    }

    public static int solution(String location) {
        // 움직임 벡터
        int[] move_type_x = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
        int[] move_type_y = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};

        //min = 49, max = 56
        int x = location.charAt(0) - '0';
        int y = location.charAt(1);

        System.out.println(x);
        System.out.println(y);

        int count = 0;
        for(int i=0; i<move_type_x.length; i++) {
            if(x + move_type_x[i] < 49 || x + move_type_x[i] > 56 || y + move_type_y[i] < 49 || y + move_type_y[i] > 56) continue;
            count += 1;
        }

        return count;
    }
}
