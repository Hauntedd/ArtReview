package main.java.learning.LeetCode;
/*
二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
思路：（关键是要记得二叉搜索树是有顺序的）
最近祖先，一定满足一个条件：两个节点分别在它的左右子树上
1.从根节点开始遍历树
2.如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
3.如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
4.如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了
* */
public class _235_erchaSousuoshuZuxian {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//递归
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal > parentVal && qVal > parentVal){//都在右子树上
            return lowestCommonAncestor(root.right,p,q);
        }else if(pVal < parentVal && qVal < parentVal){//都在左子树上
            return lowestCommonAncestor(root.left,p,q);
        }else{//分别在两个子树上
            return root;
        }
    }
}
