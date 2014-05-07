//============================================================================
// Binary Tree PreOrder Traversal
//
// Given a binary tree, return the preorder traversal of its nodes' values.
// 
// For example,
//
// Given binary tree {1,#,2,3},
// /*  1    */
// /*   \   */
// /*    2  */
// /*   /   */
// /*  3    */
// return [1,2,3].
//
// Note: Recursive solution is trivial, could you do it iteratively?
//
// Complexity:
// O(n) time, O(h) space, h is the depth of tree
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        for (; root != null; root = root.left) {
            res.add(root.val);
            stk.push(root);
        }
        while (!stk.empty()) {
            root = stk.pop();
            for (root = root.right; root != null; root = root.left) {
                res.add(root.val);
                stk.push(root);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ArrayList<Integer> res = sol.preorderTraversal(root);
        for (Integer n : res)
            System.out.print(n + " ");
        System.out.println();
    }
}
