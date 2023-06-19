package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 - 13305: Greedy - 주유소
 * https://www.acmicpc.net/problem/13305
 */
public class Baekjoon13305 {

//    static List<Integer> distanceList = List.of(3, 3, 4);
//    static List<Integer> oilPriceList = List.of(1, 1, 1, 1);

    static List<Long> distanceList = new ArrayList<>();
    static List<Long> oilPriceList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            distanceList.add(Long.valueOf(st.nextToken()));
        }

        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            oilPriceList.add(Long.valueOf(st2.nextToken()));
        }

        long money = 0L;
        long nowOilPrice = oilPriceList.get(0);

        for (int i=0; i<N-1; i++) {
            if (nowOilPrice > oilPriceList.get(i)) {
                nowOilPrice = oilPriceList.get(i);
            }

            money += (nowOilPrice * distanceList.get(i));
        }

        System.out.println("result = " + money);
    }

}

