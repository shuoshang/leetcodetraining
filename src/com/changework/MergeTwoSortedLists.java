package com.changework;

//一般方案
//1.1 解题思想
//（1）对空链表存在的情况进行处理，假如 pHead1 为空则返回 pHead2 ，pHead2 为空则返回 pHead1。（两个都为空此情况在pHead1为空已经被拦截）
// （2）在两个链表无空链表的情况下确定第一个结点，比较链表1和链表2的第一个结点的值，将值小的结点保存下来为合并后的第一个结点。并且把第一个结点为最小的链表向后移动一个元素。
// （3）继续在剩下的元素中选择小的值，连接到第一个结点后面，并不断next将值小的结点连接到第一个结点后面，直到某一个链表为空。
// （4）当两个链表长度不一致时，也就是比较完成后其中一个链表为空，此时需要把另外一个链表剩下的元素都连接到第一个结点的后面。
//2.1 解题思想
//（1）对空链表存在的情况进行处理，假如 pHead1 为空则返回 pHead2 ，pHead2 为空则返回 pHead1。 （2）比较两个链表第一个结点的大小，确定头结点的位置 （3）头结点确定后，继续在剩下的结点中选出下一个结点去链接到第二步选出的结点后面，然后在继续重复（2 ）（3） 步，直到有链表为空。
//2.2 代码实现
//ListNode* mergeTwoOrderedLists(ListNode* pHead1, ListNode* pHead2){
//    ListNode* newHead = NULL;
//    if (NULL == pHead1){
//        return pHead2;
//    }else if(NULL ==pHead2){
//        return pHead1;
//    }else{
//        if (pHead1->data < pHead2->data){
//            newHead = pHead1;
//            newHead->next = mergeTwoOrderedLists(pHead1->next, pHead2);
//        }else{
//            newHead = pHead2;
//            newHead->next = mergeTwoOrderedLists(pHead1, pHead2->next);
//         }
//        return newHead;
//    }
//}
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode dh = root;
        ListNode p = l1;
        ListNode q = l2;
        if(p==null){
            return l2;
        }
        if(q==null){
            return l1;
        }
        while( (p != null) && (q!= null) ) {
            int a=p.val;
            int b=q.val;
            if(a<b){
               ListNode tmp = new ListNode(a);
               dh.next=tmp;
               dh=dh.next;
               p=p.next;
            }else if(a>b){
                ListNode tmp = new ListNode(b);
                dh.next=tmp;
                dh=dh.next;
                q=q.next;
            }else{
                ListNode tmp = new ListNode(a);
                dh.next=tmp;
                dh=dh.next;
                ListNode tmp2 = new ListNode(b);
                dh.next=tmp2;
                dh=dh.next;
                p=p.next;
                q=q.next;
            }
        }
        if(p == null) dh.next=q;
        if(q== null) dh.next=p;
        return root.next;
    }


    public static void main(String[] args) {

        // write your code here
        MergeTwoSortedLists mergeTwoSortedLists =  new MergeTwoSortedLists();
        ListNode root = new ListNode(1);
        ListNode curr1 = new ListNode(2);
        root.next= curr1;
        ListNode curr2 = new ListNode(4);
        curr1.next = curr2;

        ListNode root2 = new ListNode(1);
        ListNode curr3 = new ListNode(3);
        root2.next = curr3;
        ListNode curr4 = new ListNode(4);
        curr3.next = curr4;

//        ListNode w = root;
//        while(w!=null){
//            System.out.println(w.val);
//            w=w.next;
//        }
        ListNode root1 = mergeTwoSortedLists.mergeTwoLists(root,root2);
        ListNode t = root1;
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}
