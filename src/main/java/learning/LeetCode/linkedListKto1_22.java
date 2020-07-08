package main.java.learning.LeetCode;

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
队列优先级？
* */

import java.util.PriorityQueue;
import java.util.Queue;

public class linkedListKto1_22 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 创建优先队列，设置比较器为队列节点值从小到大排列。v1-v2是小顶堆，v2-v1就是大顶堆
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);//lambda表达式，这个队列会自动根据节点值大小来排列链表，根节点最小的在最前面
        // 将数组中有序链表的头节点依次加入到优先队列中。
        for (ListNode node : lists) {
            if(node != null){//把每条链表都添加到队列中
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);// 定义一个头节点用于指向合并后有序链表的头节点。
        ListNode tail = dummyHead;// 定义一个指针节点用来辅助拼接有序链表。
        while (!pq.isEmpty()){
            // 依次取出值较小的头节点合并。
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            // 如果当前链表还有节点，则将新的头节点入队。
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }
}

/*参考：两两合并(递归)，要写三个函数，还是上面的方法好一点
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return merge2Lists(l1, l2);//这是上一道题合并方法
    }
}
* */
