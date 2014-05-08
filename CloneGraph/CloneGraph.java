//============================================================================
// Clone an undirected graph. Each node in the graph contains a label and a 
// list of its neighbors.
//
// Note:
// Nodes are labeled uniquely.
//
// We use # as a separator for each node, and , as a separator for node label 
// and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
// The graph has a total of three nodes, and therefore contains three parts 
// as separated by #.
//
// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus 
// forming a self-cycle.
//
// Complexity:
// BFS or DFS, O(V+E) time, O(E) space
//============================================================================

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for undirected graph.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        return cloneGraph2(node);
    }

    private UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> tb = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return dfs(node, tb);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode u, Map<UndirectedGraphNode, UndirectedGraphNode> tb) {
        if (!tb.containsKey(u)) {
            tb.put(u, new UndirectedGraphNode(u.label));
            for (UndirectedGraphNode v : u.neighbors)
                tb.get(u).neighbors.add(dfs(v, tb));
        }
        return tb.get(u);
    }

    private UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> qs = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> tb = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        tb.put(node, new UndirectedGraphNode(node.label));
        qs.add(node);
        while (!qs.isEmpty()) {
            UndirectedGraphNode u = qs.poll();
            for (UndirectedGraphNode v : u.neighbors) {
                if (!tb.containsKey(v)) {
                    tb.put(v, new UndirectedGraphNode(v.label));
                    qs.add(v);
                }
                tb.get(u).neighbors.add(tb.get(v));
            }
        }
        return tb.get(node);
    }

    private static void print(UndirectedGraphNode node) {
        if (node == null) return;
        Queue<UndirectedGraphNode> qs = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> vs = new HashSet<UndirectedGraphNode>();
        qs.add(node);
        while (!qs.isEmpty()) {
            UndirectedGraphNode u = qs.poll();
            System.out.print(u.label + ":");
            for (UndirectedGraphNode v : u.neighbors) {
                System.out.print(" " + v.label);
                if (!vs.contains(v)) {
                    vs.add(v);
                    qs.add(v);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(new UndirectedGraphNode(1));
        node.neighbors.add(new UndirectedGraphNode(2));
        node.neighbors.get(0).neighbors.add(node.neighbors.get(1));
        node.neighbors.get(1).neighbors.add(node.neighbors.get(1));
        print(sol.cloneGraph(node));
    }
}