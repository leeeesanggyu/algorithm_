package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Stack10828 {
    public static void main(String[] args) throws Exception {
        List<Integer> stack = new ArrayList<>();
        String command;

        int count;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++) {
            command = br.readLine();
            if (command.contains("push")) {
                push(stack, command);
            } else if (command.equals("pop")) {
                pop(stack);
            } else if (command.equals("size")) {
                size(stack);
            } else if (command.equals("empty")) {
                empty(stack);
            } else if (command.equals("top")) {
                top(stack);
            }
        }
    }

    private static void top(List<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(stack.get(stack.size() - 1));
        }
    }

    private static void empty(List<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void size(List<Integer> stack) {
        int stackSize = stack.size();
        System.out.println(stackSize);
    }

    private static void pop(List<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("-1");
        } else {
            int removeIndex = stack.size() - 1;
            System.out.println(stack.get(removeIndex));
            stack.remove(removeIndex);
        }
    }

    private static void push(List<Integer> stack, String command) {
        Integer X = Integer.valueOf(command.split(" ")[1]);
        stack.add(X);
        command = null;
    }

}



