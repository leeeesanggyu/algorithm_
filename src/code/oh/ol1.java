package code.oh;

import java.io.IOException;
import java.util.Stack;

public class ol1 {
    /**
     * 문자열 s가 주어집니다. 문자열 s는 "(", ")", "{", "}", "[", "]" 만 포함되어 있습니다. 문자열이 다음의 조건을 만족하면 유효하다고 판단합니다.
     * 여는 괄호들은 반드시 같은 타입의 괄호들로 닫혀야 합니다.
     * 여는 괄호들은 반드시 순서대로 닫혀야 합니다.
     * 모든 닫는 괄호는 그에 걸맞게 같은 타입의 여는 괄호가 있어야 합니다.
     * 주어지 문자열이 유효한지 판단하는 함수를 만들어주세요.
     * 제약사항
     * 1 <= s.length <= 104
     * s는 ‘()[]{}’로 구성되어 있습니다.
     * Examples
     * Example1
     * 입력: s = "([]){}"
     * 출력: true
     *
     * Example2
     * 입력: s = "[(]){}"
     * 출력: false
     */
    public static void main(String[] args) throws IOException {
        final String input = ")))";
//        final String input = "[(]){}";

        Stack<String> stack = new Stack<>();

        String[] inputs = input.split("");

        for (String inputElement : inputs) {
            if (inputElement.equals("(") || inputElement.equals("[") || inputElement.equals("{")) {
                stack.push(inputElement);
            } else {
                if (stack.isEmpty()) {
                    stack.push(inputElement);
                } else if (stack.peek().equals("(") && inputElement.equals(")") || stack.peek().equals("[") && inputElement.equals("]") || stack.peek().equals("{") && inputElement.equals("}")) {
                    stack.pop();
                } else {
                    stack.push(inputElement);
                }
            }
        }

        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }
}

