package com.changework;

import java.util.Stack;

//以本题为例：
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
//变换的是 2，3，4这三个点，那么我们可以先取出 2 ，用 front 指针指向 2 ，然后当取出 3 的时候，我们把 3 加到 2 的前面，
// 把 front 指针前移到 3 ，
// 依次类推，到 4 后停止，这样我们得到一个新链表 4 -> 3 -> 2 , front 指针指向4。
//对于原链表来说，有两个点的位置很重要，需要用指针记录下来，分别是 1 和 5 ，把新链表插入的时候需要这两个点的位置。
//用 pre 指针记录 1 的位置
//当 4 结点被取走后，5 的位置需要记下来
//这样我们就可以把倒置后的那一小段链表加入到原链表中


//栈
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead1 = new ListNode();
        ListNode d1 = dummyHead1;
        ListNode dummyHead2 = new ListNode();
        ListNode d2 = dummyHead2;

        ListNode dummyHead = new ListNode();
        dummyHead  =head;
        ListNode p = dummyHead;

        for(int j=1;j<m;j++){
            ListNode tmp = new ListNode(p.val);
            d1.next=tmp;
            d1=d1.next;
            p=p.next;
        }
        Stack<ListNode> s = new Stack<>();
        for(int i = m;i <= n && p!=null; i++){
            if(i ==n){
                d2.next = p.next;
                ListNode newp = new ListNode(p.val);
                s.push(newp);
                p = p.next;
            }else if((i >=m) && i < n){
                ListNode newp = new ListNode(p.val);
                s.push(newp);
                p = p.next;
            }else{
                p = p.next;
            }
        }
        while(!s.isEmpty()){
            d1.next=s.peek();
            d1=d1.next;
            s.pop();
        }
        d1.next = d2.next;
        return dummyHead1.next;

    }

    public static void main(String[] args) {

        // write your code here
        ReverseLinkedListII reverseLinkedListII =  new ReverseLinkedListII();
//        ListNode head = new ListNode();
        ListNode root = new ListNode(1);
//        head.next = root;
        ListNode curr1 = new ListNode(2);
        root.next= curr1;
        ListNode curr2 = new ListNode(3);
        curr1.next = curr2;
        ListNode curr3 = new ListNode(4);
        curr2.next = curr3;
        ListNode curr4 = new ListNode(5);
        curr3.next = curr4;
//        ListNode w = head;
//        w = w.next;
//        while(w!=null){
//            System.out.println(w.val);
//            w=w.next;
//        }
        ListNode root2 = reverseLinkedListII.reverseBetween(root,2,4);
        ListNode t = root2;
//        while(t!=null){
//            System.out.println(t.val);
//            t=t.next;
//        }
    }
}
