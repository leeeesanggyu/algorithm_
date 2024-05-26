package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Rid {
    public static void main(String[] args) throws IOException {
//        int[] people = new int[]{1, 3, 3, 2, 4, 3, 3, 2, 4, 2, 2, 4};
        int[] people = new int[]{1, 1, 3, 3, 3, 3, 1, 3, 3, 3, 3, 2};

        // 빈도수를 저장할 HashMap 생성
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // 결과를 저장할 리스트
        ArrayList<Integer> resultList = new ArrayList<>();

        // 배열을 순회하면서 빈도수 계산 및 결과 리스트에 추가
        for (int num : people) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (frequencyMap.get(num) % 4 == 0) {
                resultList.add(num);
            }
        }

        // 결과를 배열로 변환
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
    }
}