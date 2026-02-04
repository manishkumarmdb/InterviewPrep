package org.takeuforward.strivers79;

public class MaximumSumPathInBinaryTree {
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  private int max_sum = Integer.MIN_VALUE;

  private int maxPathSum(TreeNode root) {
    maxSumPath(root);
    return max_sum;
  }

  private int maxSumPath(TreeNode node) {
    if (node == null) {
      return 0;
    }

    // Max contribution from left & right (ignore negatives)
    int leftNodePath = Math.max(0, maxSumPath(node.left));
    int rightNodePath = Math.max(0, maxSumPath(node.right));

    int currentNodePathSum = node.val + leftNodePath + rightNodePath;

    // Max path passing through this node
    max_sum = Math.max(max_sum, currentNodePathSum);

    // Return max contribution to parent
    return node.val + Math.max(leftNodePath, rightNodePath);
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.right = new TreeNode(6);
    root.left.right.right.right = new TreeNode(7);

    // Creating an instance of the MaximumSumPathInBinaryTree class
    MaximumSumPathInBinaryTree obj = new MaximumSumPathInBinaryTree();

    // Finding and printing the maximum path sum
    int maxPathSum = obj.maxPathSum(root);
    System.out.println("Maximum Path Sum: " + maxPathSum);
  }
}
