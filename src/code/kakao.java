package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class kakao {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
        ));
    }

    private static String[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> termList = new ArrayList<>();
        Arrays.stream(terms).forEach(e -> {
            String[] termSplit = e.split(" ");
            termList.add(Integer.valueOf(termSplit[1]));
        });
        System.out.println("termList : " + termList);

        Arrays.stream(privacies).forEach(e -> {
            String[] privacy = e.split(" ");
            int privacyTerm = privacy[1].charAt(0) - 65;
            Integer month = termList.get(privacyTerm);

            String[] splitPrivacy = privacy[0].split("\\.");
            splitPrivacy[1] = splitPrivacy[1] + month;
            if (Integer.parseInt(splitPrivacy[1]) > 12) {
                splitPrivacy[0] = splitPrivacy[0] + (Integer.parseInt(splitPrivacy[1]) / 12);
                splitPrivacy[1] = String.valueOf(Integer.parseInt(splitPrivacy[1]) - (Integer.parseInt(splitPrivacy[1]) % 12));
            }
            if (Integer.parseInt(today.replace(".", ""))
                    <
                    Integer.parseInt(splitPrivacy[0] + splitPrivacy[1] + splitPrivacy[2])) {
                System.out.println(e);
            }
        });

        return null;
    }
}