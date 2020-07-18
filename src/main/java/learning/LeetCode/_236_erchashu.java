package main.java.learning.LeetCode;
/*
二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
* */
public class _236_erchashu {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//递归方法
        if (root == null || root == p || root == q ) {//根节点为空，或者查找到左右子节点之一就返回了,相当于递归的终点
            return root;
        }
        TreeNode leftCommonAncestor =  lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor =  lowestCommonAncestor(root.right, p, q);
        //在左子树中没有找到，那一定在右子树中,返回右子树的查询结果
        if(leftCommonAncestor == null){//能执行到这里说明左右两边都已经查询到底或者查询到节点了
            return rightCommonAncestor;
        }
        //在右子树中没有找到，那一定在左子树中，返回左子树的查询结果
        if(rightCommonAncestor == null){
            return leftCommonAncestor;
        }

        //不在左子树，也不在右子树，那说明是根节点)(这里是结果)
        return root;//当一个节点左右子树都有所需值的时候，才返回当前节点为结果
    }

}
