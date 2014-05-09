//============================================================================
// Word Ladder
// Given two words (start and end), and a dictionary, find the length of 
// shortest transformation sequence from start to end, such that:
//
// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,
//
// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//============================================================================

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> cq = new LinkedList<String>(), nq = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        int level = 1;
        cq.add(start);
        while (!cq.isEmpty()) {
            while (!cq.isEmpty()) {
                String cur = cq.poll();
                StringBuilder sb = new StringBuilder(cur);
                for (int i = 0; i < sb.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String next = sb.toString();
                        if (next.equals(end)) return level + 1;
                        if (dict.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            nq.add(next);
                        }
                    }
                    sb.setCharAt(i, cur.charAt(i));
                }
            }
            Queue<String> tmp = cq;
            cq = nq;
            nq = tmp;
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.ladderLength(
                "hit",
                "cog",
                new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot","log"))));

        System.out.println(sol.ladderLength(
                "hot",
                "dot",
                new HashSet<String>(Arrays.asList("hot","dot","dog"))));

        System.out.println(sol.ladderLength(
                "hot",
                "dog",
                new HashSet<String>(Arrays.asList("hot","dog"))));
    }
}