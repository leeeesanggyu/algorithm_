package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 2493번: 탑
 * https://www.acmicpc.net/problem/2493
 */
public class Baekjoon2493_timeover {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        String[] t = br.readLine().split(" ");
//        Integer N = 5;
//        String[] t = "6 9 5 7 4".split(" ");

        ArrayList<Integer> top = new ArrayList<>();
        Arrays.stream(t).forEach(e -> top.add(Integer.valueOf(e)));
        Collections.reverse(top);
//        System.out.println(top);

        ArrayList<Integer> susin = new ArrayList<>();

        for (int i=0; i<top.size(); i++) {
            for (int j=i; j< top.size(); j++) {
                if (top.get(i) < top.get(j)) {  // 수신하는 탑이 있다면 result 에 index 추가
//                    System.out.println("i : " + i + ", j :" + j);
                    susin.add(j);
                    break;
                }
                if (j == top.size() - 1) {  // 수신하는 탑이 존재하지 않으면 0 추가
                    susin.add(0);
                }
            }
        }
//        System.out.println(susin);

        Collections.reverse(susin);
//        System.out.println(susin);

        StringBuilder sb = new StringBuilder();
        susin.forEach(e -> {
            if (e != 0) {
                sb.append(susin.size() - e).append(" ");
            } else {
                sb.append(0).append(" ");
            }

        });
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}