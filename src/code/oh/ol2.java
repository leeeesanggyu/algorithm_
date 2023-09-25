package code.oh;

import java.io.IOException;
import java.util.Stack;

public class ol2 {
    /**
     * Problem
     *
     * 여는 괄호 '('와 닫는 괄호 ')'로만 이루어진 문자열이 있다. 이 문자열의 괄호 쌍이 올바르게 짝지어지도록 괄호를 임의로 추가한다면, 최소 몇개를 추가하면 되겠는가?
     *
     * Example 1:5
     * Input: s = "())"
     * Output: 1
     *
     * Example 2:
     * Input: s = "((("
     * Output: 3
     */
    public static void main(String[] args) throws IOException {
//        final String input = "())";
        final String input = "(((";
//        final String input = "))((";

        String[] splitInput = input.split("");

        Stack<String> stack = new Stack<>();

        for (String inputElement : splitInput) {
            if (stack.isEmpty()) {
                stack.push(inputElement);
            } else if (stack.peek().equals("(") && inputElement.equals(")")) {
                stack.pop();
            } else {
                stack.push(inputElement);
            }
        }

        System.out.println("stack : " + stack.size());
    }
}

