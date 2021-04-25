package PolishNotation_RadixSort.MathEvaluator;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ShuntingYardAlgorithm {
    public static final Scanner sc = new Scanner(System.in);

    public static void postFixEvaluator() {
        HashMap<String, Integer> op = new HashMap<>(5);
        op.put("+", 11);
        op.put("-", 11);
        op.put("*", 12);
        op.put("/", 12);
        op.put("^", 13);

        Deque<String> stack = new LinkedList<>();
        Deque<String> queue = new LinkedList<>();

        String s = sc.nextLine();
        while (!s.equals("?")) {
            if (Character.isDigit(s.charAt(0))) {
                queue.offer(s);
            } else if (op.containsKey(s)) {
                while (!stack.isEmpty() && !stack.peek().equals("(") && (op.get(s) < op.get(stack.peek())
                        || (op.get(s).equals(op.get(stack.peek())) && !stack.peek().equals("^"))) ) {
                    queue.offer(stack.pop());
                }
                stack.push(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.offer(stack.pop());
                }

                if (stack.isEmpty()) {
                    System.out.println("Expresion useless / wrong!");
                } else {
                    stack.pop();
                }
            }

            s = sc.nextLine();
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                System.out.println("Expresion useless / wrong!");
                break;
            }

            queue.offer(stack.pop());
        }

        Deque<Integer> listResult = new LinkedList<>();

        while (!queue.isEmpty()) {
            int result = 0;
            String str = queue.poll();

            if (Character.isDigit(str.charAt(0))) {
                listResult.push(Integer.parseInt(str));
            } else {
                if (listResult.peek() == null) {
                    System.out.println("Expresion useless / wrong!");
                }
                int op1 = listResult.pop();
                if (listResult.peek() == null) {
                    System.out.println("Expresion useless / wrong!");
                }
                int op2 = listResult.pop();
                switch (str) {
                    case "+" -> result = op2 + op1;
                    case "-" -> result = op2 - op1;
                    case "*" -> result = op2 * op1;
                    case "/" -> result = op2 / op1;
                    case "^" -> result = (int) Math.pow(op2, op1);
                    default -> System.out.println("Something is wrong!");
                }

                listResult.push(result);
            }
        }

        int finalResult = listResult.pop();

        if (!listResult.isEmpty()) {
            System.out.println("Something is wrong!");
        } else {
            System.out.println("The final result is: " + finalResult);
        }
    }


}
