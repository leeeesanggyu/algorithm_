package code;

import java.util.ArrayList;
import java.util.HashMap;

public class 실패율_실패율까지구함 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    private static int solution(int N, int[] stages) {
        ArrayList<Integer> stage = new ArrayList<>();
        for (int i: stages) {
            stage.add(i);
        }
        System.out.println("stage : " + stage);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n=1; n<=N+1; n++) {

            for (int i=0; i<stage.size(); i++) {
                if (n >= stage.get(i)) {

                    if(map.get(n) != null) {
                        map.put(n, map.get(n) + 1);
                    } else {
                        map.put(n, 1);
                    }

                }
            }

        }

        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        System.out.println("map : " + map);

        HashMap<Integer, Double> answer = new HashMap<>();
        int temp = stage.size();
        int temp2 = 0;

        for (int n=1; n<=N; n++) {
            if(map.get(n-1) == null) {
                answer.put(n, (double) (map.get(n) - temp2) / temp);
            } else {
                answer.put(n, (double) (map.get(n) - temp2) / (temp - map.get(n-1)));
                System.out.println( map.get(n) + "-" + temp2 + " / " + temp + "-" + map.get(n-1));
            }
            temp2 = map.get(n);
        }
        System.out.println(answer);

        return 1;
    }
}