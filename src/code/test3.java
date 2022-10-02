package code;

import java.util.ArrayList;
import java.util.List;

public class test3 {
    static public int answer = Integer.MIN_VALUE;
    static public int[][] board = new int[][]{
            {1, -7, -2, 1, -1},
            {2, 3, 0, -1, -2},
            {1, -1, 6, -1, -2},
            {-1, 1, -2, 0, 4},
            {-10, 5, -3, -1, 1}
    };

    public static void main(String[] args) throws Exception {
        quest(0, 0, board[0][0]);
        System.out.println(answer);
//        System.out.println(maxScore);
    }

    static void quest(int x, int y, int score) {
        final boolean xWall = board.length - 1 > x;
        final boolean yWall = board[0].length - 1 > y;

        if(!xWall && !yWall) {
            if(answer < score) {
                answer = score;
                return;
            }
        }
        if(xWall) {
            execute(x+1, y, score);
        }
        if(yWall) {
            execute(x, y+1, score);
        }
    }

    static void execute(int x, int y, int score) {
        final int currentScore = board[x][y];
        if (currentScore == 0) {
            quest(x, y, score * -1);
        }
        quest(x, y, score + currentScore);
    }

}