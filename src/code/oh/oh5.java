package code.oh;

import java.util.Arrays;

public class oh5 {

    public static void main(String[] args) {
        final String[][] board = {
                {"O", "A", "C", "D", "E", "O", },
                {"H", "O", "T", "C", "A", "P", },
                {"P", "U", "S", "E", "T", "Z", },
        };

        final boolean result = solution(board, "OHOUSE");

        System.out.println(result);
    }

    private static boolean solution(String[][] board, String word) {

        for(int x = 0; x < board[0].length; x++) {
            for (int y = 0; y < board.length; y++) {
                final boolean result = canMake(board, word, x, y, 0);
                if(result)
                    return true;
            }
        }

        return false;
    }

    private static boolean canMake(String[][] board, String word, int fromX, int fromY, int wordCursor) {
        if(wordCursor == word.length())
            return true;

        if(board[0].length-1 < fromX || board.length-1 < fromY)
            return false;

        final String targetAlphabet = Character.toString(word.charAt(wordCursor));
        if(!board[fromY][fromX].equals(targetAlphabet))
            return false;

        final boolean resultOfMoveHorizontal = canMake(board, word, fromX+1, fromY, wordCursor+1);
        final boolean resultOfMoveVertical = canMake(board, word, fromX, fromY+1, wordCursor+1);
        // TODO 상하좌우로 움직였어야함 DP 썼어야됐을듯?

        return resultOfMoveHorizontal || resultOfMoveVertical;
    }
}

