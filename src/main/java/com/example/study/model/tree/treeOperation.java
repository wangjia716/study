package com.example.study.model.tree;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

public class treeOperation {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newLeftNode;
        TreeNode newRightNode;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            newRightNode = invertTree(left);
            root.right = newRightNode;
        } else {
            root.right = null;
        }
        if (right != null) {
            newLeftNode = invertTree(right);
            root.left = newLeftNode;
        } else {
            root.left = null;
        }
        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareLeft(root, root.left) && compareRight(root, root.right) && isValidBST(root.left) && isValidBST(root.right);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    private static boolean compareRight(TreeNode root, TreeNode right) {
        if (right == null) {
            return true;
        }
        if (right.val <= root.val) {
            return false;
        }
        if (right.left == null) {
            return right.val > root.val;
        }
        return compareRight(root, right.left);
    }

    private static boolean compareLeft(TreeNode root, TreeNode left) {
        if (left == null) {
            return true;
        }
        if (left.val >= root.val) {
            return false;
        }
        if (left.right == null) {
            return left.val < root.val;
        }
        return compareLeft(root, left.right);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode right = new TreeNode(8);
//        TreeNode left = new TreeNode(4);
//        TreeNode leftLeft = new TreeNode(11);
//        TreeNode leftLeftLeft = new TreeNode(7);
//        TreeNode leftLeftRight = new TreeNode(2);
//        TreeNode rightLeft = new TreeNode(13);
//        TreeNode rightRight = new TreeNode(4);
//        TreeNode rightRightRight = new TreeNode(1);
//        root.left = left;
//        root.right = right;
//        left.left  = leftLeft;
//        leftLeft.left = leftLeftLeft;
//        leftLeft.right = leftLeftRight;
//        right.left = rightLeft;
//        right.right = rightRight;
//        rightRight.right = rightRightRight;
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(-2);
        TreeNode third = new TreeNode(-3);
        TreeNode four = new TreeNode(1);
        TreeNode five = new TreeNode(3);
        TreeNode six = new TreeNode(-2);
        TreeNode seven = new TreeNode(-1);
        root.left = two;
        root.right = third;
        two.left = four;
        two.right = five;
        third.left = six;
        four.left = seven;
        System.out.println(hasPathSum(root, 2));
    }
}
