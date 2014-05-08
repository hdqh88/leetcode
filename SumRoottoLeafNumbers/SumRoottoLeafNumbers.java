//============================================================================
//  Given a binary tree containing digits from 0-9 only, each root-to-leaf 
//  path could represent a number.
//
//  An example is the root-to-leaf path 1->2->3 which represents the number 
//  123.
//
//  Find the total sum of all root-to-leaf numbers.
//
//  For example,
//
//  /*    1     */
//  /*   / \    */
//  /*  2   3   */
//  The root-to-leaf path 1->2 represents the number 12.
//  The root-to-leaf path 1->3 represents the number 13.
//
//  return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[]{0};
        int path = 0;
        go(root, path, res);
        return res[0];
    }

    private void go(TreeNode curNode, int path, int[] res) {
        path = 10 * path + curNode.val;
        if (curNode.left == null && curNode.right == null) {
            res[0] += path;
            return;
        }
        if (curNode.left != null) go(curNode.left, path, res);
        if (curNode.right != null) go(curNode.right, path, res);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sol.sumNumbers(root));
    }
}