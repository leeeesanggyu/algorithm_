package code.oh;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class oh1 {

    static Queue<String> inputQueue;
    static String lastRemove;

    public static void main(String[] args) throws IOException {
        String answer = "bbaaa";
        String input = "bbbaaa";
        inputQueue = new LinkedList<>(List.of(input.split("")));

        String[] answerSplit = answer.split("");
        for (String a : answerSplit) {
            if (a.equals(lastRemove)) {
                continue;
            }

            if (inputQueue.isEmpty()) {
                System.out.println(false);
                return;
            }

            if (!a.equals(inputQueue.peek())) {
                System.out.println(false);
                return;
            }
            check(a);
        }
        System.out.println(inputQueue.isEmpty());

    }

    public static void check(String character) {
        if (character.equals(inputQueue.peek())) {
            lastRemove = inputQueue.poll();
            check(character);
        }
    }
}

