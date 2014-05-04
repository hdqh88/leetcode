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

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public String reverseWords(String s) {
        return reverseWords2(s);
    }

    private String reverseWords1(String s) {
        String[] tokens = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(tokens));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            if (i != 0)
                sb.append(' ');
            sb.append(tokens[i]);
        }
        return sb.toString();
    }

    private String reverseWords2(String s) {
        StringBuilder sb1 = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ')
                end--;
            if (end == -1)
                break;
            StringBuilder sb2 = new StringBuilder();
            while (end >= 0 && s.charAt(end) != ' ')
                sb2.append(s.charAt(end--));
            if (sb1.length() > 0)
                sb1.append(' ');
            sb1.append(sb2.reverse());
        }
        return sb1.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("[" + sol.reverseWords("the sky is blue") + "]");
        System.out.println("[" + sol.reverseWords(" 1") + "]");
    }
}