//=============================================================================================================================
//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//For example, Given s = “eceba”,
//
//T is "ece" which its length is 3.
//=============================================================================================================================
/*The trick is to maintain a sliding window that always satisfies the invariant where there
are always at most two distinct characters in it. When we add a new character that breaks
this invariant, how can we move the begin pointer to satisfy the invariant? Using the
above example, our first window is the substring “abba”. When we add the character ‘c’
into the sliding window, it breaks the invariant. Therefore, we have to readjust the
window to satisfy the invariant again. The question is which starting point to choose so
the invariant is satisfied.
Let’s look at another example where S = “abaac”. We found our first window “abaa”.
When we add ‘c’ to the window, the next sliding window should be “aac”.
This method iterates n times and therefore its runtime complexity is O(n). We use three
pointers: i, j, and k.
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
int i = 0, j = -1, maxLen = 0;
for (int k = 1; k < s.length(); k++) {
if (s.charAt(k) == s.charAt(k - 1)) continue;
if (j >= 0 && s.charAt(j) != s.charAt(k)) {
maxLen = Math.max(k - i, maxLen);
i = j + 1;
}
j = k - 1;
}
return Math.max(s.length() - i, maxLen);
}
}
public int lengthOfLongestSubstring(String s) {
int[] charMap = new int[256];
Arrays.fill(charMap, -1);
int i = 0, maxLen = 0;
for (int j = 0; j < s.length(); j++) {
if (charMap[s.charAt(j)] >= i) {
i = charMap[s.charAt(j)] + 1;
}
charMap[s.charAt(j)] = j;
maxLen = Math.max(j - i + 1, maxLen);
}
return maxLen;
}
