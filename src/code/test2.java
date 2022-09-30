package code;

import java.util.*;

public class test2 {
    static List<List<Integer>> combination = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int[] arr = {-1, -2, 1, 2}; //조합을 만들 배열

        for (int i=0; i<arr.length; i++) {
            combination.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[arr.length];

        for(int r = 1; r <= arr.length ; r++) {
            comb(arr, visited, 0, r);
        }

        int answer = 0;
        int total = 0;
        for(int el: arr) {
            total += el;
        }

        for (int i=arr.length; i<combination.size(); i++) {
            System.out.println(combination.get(i));
//            int temp = 0;
//            for (int el : combination.get(i)) {
//                 temp += el;
//            }
        }
        final int i = (combination.size() + arr.length) / 2;
        final List<Integer> combiMid = combination.get(i);
        System.out.println("combi Mid : " + combiMid);

        int aa = 0;
//        for (int el: arr) {
//            if (el)
//        }
    }

    static void comb(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            save(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb(arr, visited, depth + 1, r);
        }
    }

    static void save(int[] arr, boolean[] visited) {
        final ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
                temp.add(arr[i]);
            }
        }
        combination.add(temp);
    }
}