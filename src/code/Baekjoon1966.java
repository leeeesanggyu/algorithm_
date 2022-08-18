package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 1966번: 프린터 큐
 * https://www.acmicpc.net/problem/1966
 */
public class Baekjoon1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer loop = Integer.valueOf(br.readLine());
        for (int l=0; l<loop; l++) {
            String[] input = br.readLine().split(" ");

            Integer printerLength = Integer.valueOf(input[0]);
            Integer index = Integer.valueOf(input[1]);
            int answer = 0;

            List<Integer> printer = getPrinter(br);
            while (true) {
                if (isImportant(printer)) {
                    backDocument(printer);
                    index = minusIndex(printer.size(), index);
                } else {
                    answer++;
                    if (index == 0) {
                        break;
                    }
                    printer.remove(0);
                    index = minusIndex(printer.size(), index);
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean isImportant(List<Integer> printer) {
        return printer.stream().anyMatch(p -> printer.get(0) < p);
    }

    private static void backDocument(List<Integer> printer) {
        printer.add(printer.remove(0));
    }

    private static Integer minusIndex(Integer printerLength, Integer index) {
        if (index == 0) {
            index = printerLength - 1;
        } else {
            index--;
        }
        return index;
    }

    private static List<Integer> getPrinter(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");

        List<Integer> printer = new LinkedList<>();
        for (String el: input) {
            printer.add(Integer.valueOf(el));
        }
        return printer;
    }
}