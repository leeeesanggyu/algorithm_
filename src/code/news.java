package code;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class news {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("aa1+aa2", "AA12"));
    }

    public static int solution(String str1, String str2) {
        String str1up = str1.toUpperCase();
        String str2up = str2.toUpperCase();
        List<String> str1List = sliceTwoWord(str1up);
        List<String> str2List = sliceTwoWord(str2up);
        System.out.println(str1List + ", " + str2List);

        ArrayList<String> tempList1 = specialCharaterRemove(str1List);
        ArrayList<String> tempList2 = specialCharaterRemove(str2List);
        System.out.println("checkSpecialCharacters : " + tempList1 + ", " + tempList2);

        double intersectionCnt = countIntersection(tempList1, tempList2);
        double unionCnt = countUnion(
                tempList1.size() > tempList2.size() ? tempList2 : tempList1,
                tempList1.size() > tempList2.size() ? tempList1 : tempList2
        );

        int answer = (int) ((intersectionCnt / unionCnt) * 65536);
        return answer == 0 ? 65536 : answer;
    }

    private static ArrayList<String> specialCharaterRemove(List<String> str1List) {
        ArrayList<String> tempList1 = new ArrayList<>();
        for (int i = 0; i <= str1List.size() - 1; i++) {
            if (checkSpecialCharacters(str1List.get(i))) {
                tempList1.add(str1List.get(i));
            }
        }
        return tempList1;
    }

    private static boolean checkSpecialCharacters(String text) {
        String match = "^[a-zA-Z]*$";
        boolean result = text.matches(match);
        return result;
    }

    private static int countUnion(List<String> shortList, List<String> longList) {
        ArrayList<String> result = new ArrayList<>();

        while(!shortList.isEmpty()) {
            if(longList.contains(shortList.get(0))) {
                longList.remove(shortList.get(0));
            }
            result.add(shortList.get(0));
            shortList.remove(0);
        }
        System.out.println("countUnion :" + (result.size() + longList.size()));
        return result.size() + longList.size();
    }

    private static int countIntersection(List<String> textList, List<String> textList2) {
        int intersectionCnt = 0;
        for (String textListEl: textList) {
            for (String textList2El: textList2) {
                if(textListEl.equals(textList2El)) {
                    System.out.println("겹침 :" + textListEl + ", " + textList2El);
                    intersectionCnt++;
                    break;
                }
            }
        }
        System.out.println("intersectionCnt :" + intersectionCnt);
        return intersectionCnt;
    }



    private static List<String> sliceTwoWord(String text) {
        ArrayList<String> result = new ArrayList<>();

        for (int i=0; i<text.length()-1; i++) {
            result.add(text.substring(i, i + 2));
        }
        System.out.println("sliceTwoWord :" + result);
        return result;
    }
}



