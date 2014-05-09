//============================================================================
// Word Ladder II
// Given two words (start and end), and a dictionary, find all shortest 
// transformation sequence(s) from start to end, such that:
//
// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,
//
// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// Return
//   [
//       ["hit","hot","dot","dog","cog"],
//       ["hit","hot","lot","log","cog"]
//   ]
// Note:
//  All words have the same length.
//  All words contain only lowercase alphabetic characters.
//============================================================================

//============================================================================
// Word Ladder II
// Given two words (start and end), and a dictionary, find all shortest
// transformation sequence(s) from start to end, such that:
//
// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,
//
// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// Return
//   [
//       ["hit","hot","dot","dog","cog"],
//       ["hit","hot","lot","log","cog"]
//   ]
// Note:
//  All words have the same length.
//  All words contain only lowercase alphabetic characters.
//============================================================================

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
            HashSet<String> dict) {
        Map<String, List<String>> from = new HashMap<String, List<String>>();
        Set<String> cq = new HashSet<String>(), nq = new HashSet<String>(), visited = new HashSet<String>();
        cq.add(start);
        while (!cq.isEmpty() && !cq.contains(end)) {
            for (String cur : cq)
                visited.add(cur);
            for (String cur : cq) {
                StringBuilder sb = new StringBuilder(cur);
                for (int i = 0; i < sb.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String next = sb.toString();
                        if (next.equals(end) || (dict.contains(next) && !visited.contains(next))) {
                            if (!from.containsKey(next))
                                from.put(next, new ArrayList<String>());
                            from.get(next).add(cur);
                            nq.add(next);
                        }
                    }
                    sb.setCharAt(i, cur.charAt(i));
                }
            }
            Set<String> tmp = cq;
            cq = nq;
            nq = tmp;
            nq.clear();
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (from.containsKey(end)) {
            ArrayList<String> path = new ArrayList<String>();
            path.add(end);
            go(end, start, from, path, res);
        }
        return res;
    }

    void go(String cur, String end, Map<String, List<String>> from,
            ArrayList<String> path, ArrayList<ArrayList<String>> res) {
        if (cur.equals(end)) {
            ArrayList<String> copy = new ArrayList<String>(path);
            Collections.reverse(copy);
            res.add(copy);
            return;
        }
        for (String next : from.get(cur)) {
            path.add(next);
            go(next, end, from, path, res);
            path.remove(path.size() - 1);
        }
    }

    private static void print(Object... objs) {
        System.out.println(Arrays.deepToString(objs));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        print(sol.findLadders(
                "hit",
                "cog",
                new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot","log"))));

        print(sol.findLadders(
                "hot",
                "dot",
                new HashSet<String>(Arrays.asList("hot","dot","dog"))));

        print(sol.findLadders(
                "hot",
                "dog",
                new HashSet<String>(Arrays.asList("hot","dog"))));
    }
}