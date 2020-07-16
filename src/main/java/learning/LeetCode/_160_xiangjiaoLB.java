package main.java.learning.LeetCode;
/*
编写一个程序，找到两个单链表相交的起始节点。
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

* */
public class _160_xiangjiaoLB {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB){//两个指针分别来回遍历两条链表，必然相遇
//            nodeA = (nodeA == null):
            nodeA = (nodeA != null) ? nodeA.next : headB;//注意：判断条件不能加next,保证在没有交点的情况下同时等于null跳出循环;
            nodeB = (nodeB != null) ? nodeB.next : headA;
        }
        return nodeA;
    }
}
