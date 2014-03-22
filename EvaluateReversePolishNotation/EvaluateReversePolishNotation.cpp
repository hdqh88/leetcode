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
using namespace std;


#include <iostream>
#include <stack>
#include <sstream>
#include <vector>

using namespace std;

class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        int op1, op2;
        stack<int> stk;
        for (auto str : tokens) {
            if (str == "+" || str == "-" || str == "*" || str == "/") {
                op2 = stk.top(), stk.pop();
                op1 = stk.top(), stk.pop();
                if (str == "+") stk.push(op1 + op2);
                else if (str == "-") stk.push(op1 - op2);
                else if (str == "*") stk.push(op1*op2);
                else stk.push(op1 / op2);
            }
            else {
                stk.push(stoi(str));
            }
        }
        return stk.top();
    }
};

int main() {
    return 0;
}
