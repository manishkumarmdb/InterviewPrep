package org.takeuforward.strivers79;

/*
 * https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree
 * */
public class CalculateTheDiameterOfABinaryTree {

  int diameter = 0;

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

  private int diameterOfBinaryTree(TreeNode root) {
    int[] diameter = new int[1];
    calculateHeight(root, diameter);
    return diameter[0];
  }

  private int calculateHeight(TreeNode node, int[] diameter) {
    if (node == null) return 0;
    // Recursively calculate the height of left and right subtree
    int leftHeight = calculateHeight(node.left, diameter);
    int rightHeight = calculateHeight(node.right, diameter);

    // Calculate the diameter at the current node and update the global variable
    diameter[0] = Math.max(diameter[0], (leftHeight + rightHeight));

    return 1 + Math.max(leftHeight, rightHeight);
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

    // Creating an instance of the CalculateTheDiameterOfABinaryTree class
    CalculateTheDiameterOfABinaryTree obj = new CalculateTheDiameterOfABinaryTree();

    // Calculate the diameter of the binary tree
    int diameter = obj.diameterOfBinaryTree(root);

    System.out.println("The diameter of the binary tree is: " + diameter);
  }
}
