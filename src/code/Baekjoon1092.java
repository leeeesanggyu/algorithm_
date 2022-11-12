package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 1092: 배 - Greedy
 * https://www.acmicpc.net/problem/1092
 *
 * 크레인을 돌면서 박스 크기가 큰것부터 할당해나감
 * 크레인 한바퀴가 돌면 ++
 */
public class Baekjoon1092 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        for (int i=0; i<M; i++) {
            box.add(Integer.parseInt(st2.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());
//        System.out.println(crane);
//        System.out.println(box);

        if (crane.get(0) < box.get(0)) {
            System.out.println("-1");
            return;
        }

        int time = 0;
        while(!box.isEmpty()) {
            for (Integer curCrane : crane) {
                for (int i=0; i<box.size(); i++) {
//                    System.out.println("crane : " + curCrane + ", box : " + box.get(i));
                    if (curCrane >= box.get(i)) {
                        box.remove(i);
                        break;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
    }
}

