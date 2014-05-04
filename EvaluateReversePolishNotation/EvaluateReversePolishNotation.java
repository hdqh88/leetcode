//============================================================================
// Evaluate Reverse Polish Notation
//
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
// Valid operators are +, -, *, /. Each operand may be an integer or another 
// expression.
//
// Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//
// Complexity:
// O(n) time, O(n) space
//============================================================================

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        int op1, op2;
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*")
                    || t.equals("/")) {
                op2 = stk.pop();
                op1 = stk.pop();
                if (t.equals("+"))
                    stk.push(op1 + op2);
                else if (t.equals("-"))
                    stk.push(op1 - op2);
                else if (t.equals("*"))
                    stk.push(op1 * op2);
                else if (t.equals("/"))
                    stk.push(op1 / op2);
            } else {
                stk.push(Integer.parseInt(t));
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(sol.evalRPN(tokens));
        tokens = new String[] { "4", "13", "5", "/", "+" };
        System.out.println(sol.evalRPN(tokens));
    }
}