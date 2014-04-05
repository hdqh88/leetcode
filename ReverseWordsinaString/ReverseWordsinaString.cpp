//============================================================================
// Reverse Words in a String
// Given an input string, reverse the string word by word.
//
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
//
// click to show clarification.
//
// Clarification:
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing 
// spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.
//============================================================================

#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void reverseWords(string & s) {
        reverseWords1(s);
    }

    void reverseWords1(string &s) {
        istringstream is(s);
        string word;
        vector<string> vs;
        while (is >> word) vs.push_back(word);
        reverse(begin(vs), end(vs));
        s.clear();
        ostringstream os;
        for (int i = 0; i < vs.size(); i++) {
            if (i != 0) os << " ";
            os << vs[i];
        }
        s = os.str();
    }

    void reverseWords2(string &s) {
        string res;
        int i = s.size() - 1;
        while (i >= 0) {
            while (i >= 0 && s[i] == ' ') i--;
            if (i < 0) break;
            if (!res.empty()) res.push_back(' ');
            string tmp;
            while (i >= 0 && s[i] != ' ') tmp.push_back(s[i--]);
            reverse(tmp.begin(), tmp.end());
            res.append(tmp);
        }
        s = res;
    }
};

int main() {
    Solution sol;
    string s = "  the  sky  is   blue  ";
    sol.reverseWords(s);
    cout << "[" << s << "]" << endl;
    return 0;
}
