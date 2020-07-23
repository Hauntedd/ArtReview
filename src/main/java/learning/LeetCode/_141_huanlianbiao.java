package main.java.learning.LeetCode;

/*
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
* */
import java.util.HashSet;
import java.util.Set;

public class _141_huanlianbiao {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();//用来存储遍历过的节点的引用
        while (head != null){
            if(nodesSeen.contains(head))//这个可以记一下，contains方法针对的是对象equals
                return true;
            else
                nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {//142,返回入环的第一个节点
        Set<ListNode> nodeSeen = new HashSet<>();
        while (head != null){
            if(nodeSeen.contains(head))
                return head.next;
            else
                nodeSeen.add(head);
            head = head.next;
        }
        return null;//五环
    }
}
