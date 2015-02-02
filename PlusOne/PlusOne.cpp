//============================================================================
// PlusOne
// Given a number represented as an array of digits, plus one to the number.
// 
// Complexity:
// O(n)
//============================================================================

#include <vector>

using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        vector<int> res = digits;
        int i = res.size() - 1;
        for (; i >= 0; i--) {
            if (res[i] < 9) {
                res[i]++;
                break;
            }
            else res[i] = 0;
        }
        if (i == -1) res.insert(res.begin(), 1);
        return res;
    }
    
    
    
    // Hao
    vector<int> plusOne2(vector<int> &digits) {
        int carry = 0;
        vector<int>::iterator iter = digits.end() - 1;
        int value = (*iter + carry + 1) % 10;
        carry = (*iter + carry + 1) / 10;
        *iter-- = value;
        while(iter >= digits.begin()){
            if(carry == 0)
                break;
            value = (*iter + carry) % 10;
            carry = (*iter + carry) / 10;
            *iter-- = value;
        }
        if(carry)
            digits.insert(digits.begin(), 1);
        return digits;
    }
    
};

int main() {
    return 0;
}
