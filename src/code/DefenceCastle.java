package code;

import java.util.ArrayList;

/**
 * 이코테 - 1이 될때까지
 */
public class DefenceCastle {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new String[][]{
                {"대", "한", "가", "나"},
                {"국", "민", "다", "라"},
                {"마", "바", "사", "아"},
                {"자", "차", "카", "타"}
        }, "카사"));
    }

    public static int solution(String[][] puzzle, String word) throws Exception {
        int answer = 0;
        int y_cursor = 0;
        int x_cursor = 0;

        //우 하 좌 상
        int[] x_vector = {0, 1, 0, -1};
        int[] y_vector = {1, 0, -1, 0};

        final String[] splitWord = word.split("");

        //첫 단어 위치 찾기
        for(int i=0; i< puzzle.length; i++) {
            for(int j=0; j< puzzle[i].length; j++) {
                if(splitWord[0].equals(puzzle[i][j])) {
                    x_cursor = j;
                    y_cursor = i;
                    break;
                }
            }
        }

        //단어 순회
        for(int i=0; i<word.length(); i++) {

            //벡터별 확인
            for(int j=0; j<x_vector.length; j++) {
                // limit
                if((x_cursor + x_vector[j]) < puzzle.length || (x_cursor + x_vector[j]) >= 0 || (y_cursor + y_vector[j]) >= 0 || (y_cursor + y_vector[j]) < puzzle.length) {
                    if(puzzle[(x_cursor + x_vector[j])][(y_cursor + y_vector[j])].equals(splitWord[i])) {
                        x_cursor = x_cursor + x_vector[j];
                        y_cursor = y_cursor + y_vector[j];
                        System.out.println(x_cursor + ", " + y_cursor);
                        break;
                    }
                }

            }

        }

//        System.out.println("x : " + x_cursor);
//        System.out.println("y : " + y_cursor);
        System.out.println("answer : " + puzzle[x_cursor][y_cursor]);




        return answer;
    }
}



