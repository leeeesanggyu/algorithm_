package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kwak3 {
    public static void main(String[] args) {
//        List<String> input = List.of("{", "}", "(", ")", "[", "]");
        List<String> input = List.of("{", "}", "(");

        Stack<String> stack = new Stack<>();
        stack.add(input.get(0));

        for (int i=1; i< input.size(); i++) {
            if (!stack.isEmpty()) {
                String peek = stack.peek();
                String inputElement = input.get(i);

                if (peek.equals("{") && inputElement.equals("}")) {
                    stack.pop();
                } else if (peek.equals("(") && inputElement.equals(")")) {
                    stack.pop();
                } else if (peek.equals("[") && inputElement.equals("]")) {
                    stack.pop();
                } else {
                    stack.add(inputElement);
                }
            } else {
                stack.add(input.get(i));
            }
        }

        if (stack.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}

