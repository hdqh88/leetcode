//============================================================================
// Binary Tree Postorder Traversal
//
// Given a binary tree, return the postorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
// return [3,2,1].
//
// Note: Recursive solution is trivial, could you do it iteratively?
//
// Complexity:
// O(n) time, O(k) space, k is the depth of tree
//============================================================================

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        pushPath(stk, root);
        while (!stk.empty()) {
            root = stk.pop();
            if (!stk.empty() && stk.peek().left == root) pushPath(stk, stk.peek().right);
            res.add(root.val);
        }
        return res;
    }

    private void pushPath(Stack<TreeNode> stk, TreeNode root) {
        while (root != null) {
            stk.push(root);
            if (root.left != null) root = root.left;
            else root = root.right;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ArrayList<Integer> res = sol.postorderTraversal(root);
        for (Integer n : res) System.out.print(n + " ");
        System.out.println();
    }
}