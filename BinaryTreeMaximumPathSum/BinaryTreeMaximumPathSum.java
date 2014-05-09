//============================================================================
// Binary Tree Maximum Path Sum
// Given a binary tree, find the maximum path sum.
//
// The path may start and end at any node in the tree.
//
// For example:
// Given the below binary tree,
//
//  "     1     "
//  "    / \    "
//  "   2   3   " 
//  
//  Return 6.
//
// Complexity:
// O(n) time, O(h) space
//============================================================================

/**
 * Definition for binary tree
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[]{Integer.MIN_VALUE};
        go(root, res);
        return res[0];
    }

    int go(TreeNode root, int[] res) {
        if (root == null) return 0;
        int ls = go(root.left, res);
        int rs = go(root.right, res);
        int p = Math.max(root.val, root.val + Math.max(ls, rs));
        res[0] = Math.max(res[0], Math.max(p, root.val + ls + rs));
        return p;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sol.maxPathSum(root));
    }
}