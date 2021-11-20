package LeetCode.Stack.ValidParentheses;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println(isValid("]"));

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if(stack.isEmpty() && (ch == ')' || ch == '}' || ch == ']')) return false;
            else if (!stack.isEmpty()) {
                if (ch == ')' && stack.peek() != '(') {
                    return false;
                } else if (ch == '}' && stack.peek() != '{') {
                    return false;
                } else if (ch == ']' && stack.peek() != '[') {
                    return false;
                }

                stack.pop();
            }

        }

        return stack.isEmpty();
    }

}
