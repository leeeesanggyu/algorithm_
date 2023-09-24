package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 - 123: example - example
 * https://www.acmicpc.net/problem/123
 */
public class Baekjoon12764 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 5;
        List<Time> timeList = new ArrayList<>();
        timeList.add(new Time(20, 50));
        timeList.add(new Time(10, 100));
        timeList.add(new Time(30, 120));
        timeList.add(new Time(60, 110));
        timeList.add(new Time(80, 90));

        timeList.sort((o1, o2) -> o1.P - o2.P);
        System.out.println(timeList);

        List<List<Time>> lastQList = new ArrayList<>();

        for (Time time : timeList) {
            if (lastQList.isEmpty()) {
                lastQList.add(List.of(time));
                continue;
            }

            for (List<Time> alreadyTime : lastQList) {
                if (alreadyTime.get(alreadyTime.size() - 1).Q < time.P) {
                    alreadyTime.add(time);
                    continue;
                }
            }

            lastQList.add(List.of(time));
        }

        System.out.println(lastQList);
    }

    static class Time {
        private Integer P;
        private Integer Q;

        public Time(Integer p, Integer q) {
            P = p;
            Q = q;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "P=" + P +
                    ", Q=" + Q +
                    '}';
        }
    }
}

