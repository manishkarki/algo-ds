package com.algo.leetcode;

import java.util.Stack;

/**
 * @author mkarki
 */
public class BalancedParentheses {
    Character[][] combinations;

    public BalancedParentheses() {
        this.combinations = new Character[][]{{'(', ')'}, {'{', '}'}, {'[', ']'}};
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * <p>
     * Example 1:
     * <p>
     * Input: "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: "{[]}"
     * Output: true
     *
     * @param s
     * @return if the string is valid or not
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> openStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                openStack.push(c);
            }
            if (isClosed(c) && (openStack.isEmpty() || !areCombination(openStack.pop(), c))) {
                return false;
            }
        }
        return openStack.isEmpty();
    }

    private boolean isOpen(char c) {
        for (Character[] ref : combinations) {
            if (ref[0] == c) {
                return true;
            }
        }
        return false;
    }

    private boolean isClosed(char c) {
        for (Character[] ref : combinations) {
            if (ref[1] == c) {
                return true;
            }
        }
        return false;
    }

    private boolean areCombination(char open, char closed) {
        for (Character[] combination : combinations) {
            if (combination[0] == open && combination[1] == closed) {
                return true;
            }
        }
        return false;
    }
}
