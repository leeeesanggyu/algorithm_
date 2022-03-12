package code;

import java.util.ArrayList;
import java.util.List;

public class 프린터 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{1, 1, 9, 1, 2, 1}, 3));
    }

    public static int solution(int[] priorities, int location) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int priority : priorities) {
            list.add(priority);
        }
        int turn = 0;

        System.out.println("========================");
        System.out.println("now : " + list);
        System.out.println("loc : " + location);
        System.out.println("tun : " + turn);

        while(true) {
            int j = list.get(0);

            if(list.stream().anyMatch(v -> v > j)) {
                list.add(list.remove(0));
                System.out.println("========================");
                System.out.println("now : " + list + "skip");
                if (location == 0) {
                    location = list.size() - 1;
                }
                else {
                    location = location - 1;
                }
                System.out.println("loc : " + location);
                System.out.println("tun : " + turn);

            } else {
                if(location == 0) {
                    System.out.println("========================");
                    return turn + 1;
                }
                list.remove(0);
                turn = turn + 1;
                location = location - 1;
                System.out.println("========================");
                System.out.println("now : " + list + "pop");
                System.out.println("loc : " + location);
                System.out.println("tun : " + turn);

            }



        }

    }

}



