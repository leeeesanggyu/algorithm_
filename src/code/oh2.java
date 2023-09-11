package code;

import java.io.IOException;
import java.util.*;

public class oh2 {

    public static void main(String[] args) throws IOException {
//        String[] rolls = {"2", "3", "+", "D", "0", "3", "R"};
        String[] rolls = {"9", "D", "3", "4", "D", "R", "R", "+"};

//        Stack<Integer> board = new Stack<>();
        List<Integer> board = new ArrayList<>();

        for (int i = 0; i < rolls.length; i++) {
            switch (rolls[i]) {
                case "R":
//                    board.pop();
                    board.remove(board.size() - 1);
                    break;
                case "+": {
//                    int score = Integer.parseInt(rolls[i - 1]) + Integer.parseInt(rolls[i - 2]);
                    int score = board.get(board.size() - 1) + board.get(board.size() - 2);
                    board.add(score);
                    break;
                }
                case "D": {
//                    int score = board.peek() * 2;
                    int score = board.get(board.size() - 1) * 2;
                    board.add(score);
                    break;
                }
                default:
                    board.add(Integer.parseInt(rolls[i]));
                    break;
            }
        }

        int answer = 0;
//        while (!board.isEmpty()) {
//            answer += board.pop();
//        }
        for (int b : board) {
            answer += b;
        }
        System.out.println(answer);
    }

}

