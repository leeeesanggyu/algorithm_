package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 - 2800번: 괄호 제거
 * https://www.acmicpc.net/problem/2800
 */
public class Baekjoon2800 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
//        String n = "(1+(2*(3+4)))";
        String[] s = n.split("");
        List<String> nList = new ArrayList<>(Arrays.asList(s));
        List<String> answer = new ArrayList<>();
        List<Integer> leftPair = new ArrayList<>();
        List<Integer> rightPair = new ArrayList<>();

        getPair(nList, leftPair, rightPair);
        if (leftPair.size() != rightPair.size()) return;

        getCombination(leftPair);
//        System.out.println("조합 : " + combination);

        for(int i=0; i<combination.size(); i++) {
            List<String> tempNList = new ArrayList<>(nList);
            for(int j=0; j<combination.get(i).size(); j++) {
                deletePair(leftPair, rightPair, i, tempNList, j);
            }
            StringBuilder sb = new StringBuilder();
            tempNList.forEach(e -> {
                if (!e.equals("x")) {
                    sb.append(e);
                }
            });
            answer.add(sb.toString());
        }
        answer = removeSame(answer);
        answer.sort(String::compareTo);
        answer.forEach(System.out::println);
    }

    private static void getPair(List<String> nList, List<Integer> leftPair, List<Integer> rightPair) {
        Stack<Integer> leftTemp = new Stack<>();
        for (int i = 0; i< nList.size(); i++) {
            if (nList.get(i).equals("(")) {
                leftTemp.push(i);
            } else if (nList.get(i).equals(")")) {
                leftPair.add(leftTemp.pop());
                rightPair.add(i);
            }
        }
        System.out.println(leftPair);
        System.out.println(rightPair);
    }

    private static void getCombination(List<Integer> leftPair) {
        int[] arr = new int[leftPair.size()];
        for (int i = 0; i< leftPair.size(); i++) {
            arr[i] = i;
        }

        for(int r = 1; r <= arr.length; r++) {
            boolean[] visited = new boolean[arr.length];
            comb1(arr, visited, 0, r);
        }
    }

    private static void deletePair(List<Integer> leftPair, List<Integer> rightPair, int i, List<String> tempNList, int j) {
        tempNList.remove(leftPair.get(combination.get(i).get(j)).intValue());
        tempNList.add(leftPair.get(combination.get(i).get(j)), "x");

        tempNList.remove(rightPair.get(combination.get(i).get(j)).intValue());
        tempNList.add(rightPair.get(combination.get(i).get(j)), "x");
    }

    private static List<String> removeSame(List<String> answer) {
        HashSet<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        return answer;
    }

    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            append(arr, visited);
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    static List<List<Integer>> combination = new ArrayList<>();
    static void append(int[] arr, boolean[] visited) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                temp.add(arr[i]);
            }
        }
        combination.add(temp);
    }

}