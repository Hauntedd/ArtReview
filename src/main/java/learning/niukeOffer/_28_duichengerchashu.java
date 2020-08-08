package main.java.learning.niukeOffer;
/*
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
* */
public class _28_duichengerchashu {
    public boolean isSymmetric(TreeNode root) {//目测应该是递归
        if(root == null)
            return true;
        return recur(root.left,root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {//这个思想很不错
        if(left == null && right == null)
            return true;
        if(left == null|| right == null||left.val !=right.val)
            return false;
        return recur(left.left, right.right)&&recur(left.right, right.left);//对称着向下进行递归。
    }
}
