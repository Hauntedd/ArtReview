package main.java.learning.LeetCode;
/*
排序链表,从小到大
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
可以使用快速排序，交换值或者指针,递归方法
* */
public class _148_liaobiaoSort {
    public ListNode sortList(ListNode head) {
        quickSort(head,null);
        return head;
    }
    /***
     * 头，尾
     * @param head
     * @param end
     */
    public void quickSort(ListNode head, ListNode end){
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }
    public ListNode partion(ListNode head, ListNode end){//快排分区，以头结点的值为划分，这里用的交换数值
        ListNode p1 = head, p2 = head.next;
        //走到末尾才停
        while (p2 != end) {

            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;
                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }
        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }


    public static ListNode quicksort2(ListNode head){//不使用交换数值的方法
        //因为不能交换数值，所以我们就需要分割链表,最后返回新的链表
        if(head == null || head.next == null) return head;

        int pivot = head.val;
        //链表大小的划分
        ListNode ls = new ListNode(-1), rs = new ListNode(-1);//新建两个链表头子
        ListNode l = ls,r = rs,cur = head;//指向需要操作的节点
        while (cur != null){
            if(cur.val <pivot){//放进第一条链表
                l.next = cur;
                l = l.next;
            }else{//放进第二条链表
                r.next = cur;
                r = r.next;
            }
            ListNode aaa = cur;
            cur = cur.next;
            aaa.next = null;//每取出一个节点就取消它和后面的关联，生成完全分割的两条链表
        }

        ListNode left = quicksort2(ls.next);//递归排序左右两边的子链表
        ListNode right = quicksort2(rs.next);
        // 拼接左半部分和右半部分
        cur = left;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = right;
        return left;


        // 递归调用,先重排右边的,再把指针置空,再重排左边的
        // 和归并排序很像的

//        //原方法,
//        l.next = rs.next;//这里先把两个链表合并
//        r.next = null;
//
//        ListNode right = quicksort2(head.next);
//        head.next = null;
//        ListNode left = quicksort2(ls.next);
//
//        // 拼接左半部分和右半部分
//        cur = left;
//        while(cur.next != null){
//            cur = cur.next;
//        }
//        cur.next = right;
//        return left;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(100);
        ListNode temp = head;
        for (int i = 1; i <=10 ; i++) {
            temp.next = new ListNode(100 -i*10);
            temp = temp.next;
        }
        ListNode ans = quicksort2(head);
        for (int i = 0; i < 10; i++) {
            System.out.print(ans.val +"    ");
            ans = ans.next;
        }
    }

}
