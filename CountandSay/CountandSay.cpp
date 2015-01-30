//============================================================================
// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.
//
// Note: The sequence of integers will be represented as a string.
//============================================================================

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if(n <= 0)
            return NULL;
        string tmp;
        string seq = "1";
        int count;
        for(int i = 1; i < n; i++){
            count = 1;
            for(int j = 1; j < seq.length(); j++){
                if(seq[j] == seq[j - 1]){
                    count++;
                }
                else{
                    tmp.push_back(count + '0');
                    tmp.push_back(seq[j - 1]);
                    count = 1;
                }
            }
            tmp.push_back(count + '0');
            tmp.push_back(seq[seq.length() - 1]);
            seq = tmp;
            tmp = "";
        }
        return seq;
    }
};

int main() {

    Solution sol;

    {
        for (int i = 1; i < 6; i++)
            cout << sol.countAndSay(i) << endl;
    }
    
    return 0;
}
