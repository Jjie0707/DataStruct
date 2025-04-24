package test0;

import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (func(tokens[i])) {
                int a = s.pop();
                int b = s.pop();
                if (tokens[i].equals("+")) {
                    s.push(b + a);
                } else if (tokens[i].equals("-")) {
                    s.push(b - a);
                } else if (tokens[i].equals("*")) {
                    s.push(b * a);
                } else {
                    s.push(b / a);
                }
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.peek();
    }

    public static boolean func(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }


    public static void main0(String[] args) {
        String s = "()(){}[";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        myStack stack = new myStack();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char tem = stack.pop();

                if (c == ')' && tem != '(') {
                    return false;
                } else if (c == ']' && tem != '[') {
                    return false;
                } else if (c == '}' && tem != '{') {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    static class myStack {
        private LinkedList<Character> s = new LinkedList<>();

        public boolean empty() {
            return s.isEmpty();
        }

        public void push(char c) {
            s.addLast(c);
        }

        public char pop() {
            return s.removeLast();
        }
    }
}
