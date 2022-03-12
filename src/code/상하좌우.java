package code;

public class 상하좌우 {
    public static void main(String[] args) {
        System.out.println(solution(5, "RRRUDD"));
    }

    public static int solution(int size, String plans) {

        int location_x = 1;
        int location_y = 1;

        // R L D U
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        char[] move_type = new char[]{'R', 'L', 'D', 'U'};

        for(int i=0; i<plans.length(); i++) {
            for(int j=0; j<move_type.length; j++) {

                if(plans.charAt(i) == move_type[j]) {
                    if (location_x + dx[j] > size || location_x + dx[j] < 1 || location_y + dy[j] > size || location_y + dy[j] < 1) {
                        continue;
                    }
                    else {
                        location_x += dx[j];
                        location_y += dy[j];
                    }
                }

            }
        }

        System.out.println(location_x + ", " + location_y);
        return 1;
    }
}
