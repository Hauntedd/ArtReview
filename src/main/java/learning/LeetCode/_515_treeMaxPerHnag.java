package main.java.learning.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
在每个树行中找最大值（二叉树）
* */
public class _515_treeMaxPerHnag {
    public List<Integer> largestValues(TreeNode root) {
        //linkedLIst实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){//一次while循环是一层
            int maxValue = Integer.MIN_VALUE;
            int levelSzie = queue.size();//每一层的数量
            for (int i = 0; i < levelSzie; i++) {
                TreeNode node = queue.poll();//出队
                maxValue = (maxValue >= node.val) ? maxValue:node.val;
                //添加下一层的节点
                if (node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            values.add(maxValue);
        }
        return values;
    }
}
