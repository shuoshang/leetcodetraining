package com.changework;

//分割链表
//这道题要求我们划分链表，把所有小于给定值的节点都移到前面，大于该值的节点顺序不变，相当于一个局部排序的问题。
//设定两个虚拟节点，dummyHead1 用来保存小于于该值的链表，dummyHead2 来保存大于等于该值的链表
//遍历整个原始链表，将小于该值的放于dummyHead1 中，其余的放置在dummyHead2 中
//遍历结束后，将dummyHead2 插入到dummyHead1 后面
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode dummyHead1 = new ListNode();
        ListNode dummyHead2 = new ListNode();
        ListNode d1 = dummyHead1;
        ListNode d2 = dummyHead2;
        if(head==null || head.next ==null){
            return head;
        }
        ListNode p = head;
        while(p!=null){
            int k = p.val;
            if(k<x){
                d1.next = p;
                p = p.next;
                d1 = d1.next;
                d1.next = null;
            }else{
                d2.next = p;
                p = p.next;
                d2 = d2.next;
                d2.next = null;
            }
        }
        d1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static void main(String[] args) {

        // write your code here
        PartitionList partitionList =  new PartitionList();
//        ListNode head = new ListNode();
        ListNode root = new ListNode(1);
//        head.next = root;
        ListNode curr1 = new ListNode(4);
        root.next= curr1;
        ListNode curr2 = new ListNode(3);
        curr1.next = curr2;
        ListNode curr3 = new ListNode(2);
        curr2.next = curr3;
        ListNode curr4 = new ListNode(5);
        curr3.next = curr4;
        ListNode curr5 = new ListNode(2);
        curr4.next = curr5;

//        ListNode w = head;
//        w = w.next;
//        while(w!=null){
//            System.out.println(w.val);
//            w=w.next;
//        }
        ListNode root2 = partitionList.partition(root,3);
        ListNode t = root2;
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}
