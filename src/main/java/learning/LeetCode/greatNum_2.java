package main.java.learning.LeetCode;
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
* */
public class greatNum_2 {

    class ListNode {//链表节点类
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){//注意链表是逆序存储的
        int extra = 0;
        int val1  = 0;
        int val2  = 0;

        ListNode head = new ListNode(0); //创建头部链表节点，用来存放结果
        ListNode node = head;

        while(l1 != null || l2 != null || extra != 0){

            if(l1 != null){//取出链表的节点的值，以及下一个节点
                val1 = l1.val;
                l1   = l1.next;
            }else{
                val1 = 0;
            }

            if(l2 != null){
                val2 = l2.val;
                l2   = l2.next;
            }else{
                val2 = 0;
            }

            node.val  = (val1 + val2 + extra) % 10; //节点值相加，再加上进位，得到相加后的本位值
            extra    = (val1 + val2 + extra) / 10;  //进位值

            if(l1 == null && l2 == null && extra == 0){//两个大数的下一个节点都是空，且无进位。则结束跳出循环
                node.next = null;
                break;
            }

            ListNode tmp = new ListNode(0);// 新建一个node用于下一次循环
            node.next = tmp;
            node = tmp;

        }
        return head;
    }
}
