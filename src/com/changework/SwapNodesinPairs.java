package com.changework;


//该题属于基本的链表操作题。
//设置一个虚拟头结点dummyHead
//设置需要交换的两个节点分别为node1 、node2，同时设置node2的下一个节点next
//在这一轮操作中
//将node2节点的next设置为node1节点
//将node1节点的next设置为next 节点
//将dummyHead 节点的next设置为node2
//结束本轮操作
//接下来的每轮操作都按照上述进行。
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {

        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        ListNode root =new ListNode(0);
        ListNode dp = root;
        ListNode n1=head;
        ListNode n2=head.next;
        ListNode n3=head.next.next;
        dp.next=head;

        while( n2!= null ) {
            n2.next=n1;
            n1.next=n3;
            dp.next=n2;
            if(n1.next!=null && n1.next.next!=null){
                n1=n1.next;
                n2=n1.next;
                dp=dp.next.next;
                n3=n3.next.next;
            }else{
                break;
            }
        }

        return root.next;
    }

    public static void main(String[] args) {

        // write your code here
        SwapNodesinPairs swapNodesinPairs =  new SwapNodesinPairs();
        ListNode root = new ListNode(1);
        ListNode curr1 = new ListNode(2);
        root.next= curr1;
        ListNode curr2 = new ListNode(3);
        curr1.next = curr2;
        ListNode curr3 = new ListNode(4);
        curr2.next = curr3;
        ListNode curr4 = new ListNode(5);
        curr3.next = curr4;

//        ListNode w = root;
//        while(w!=null){
//            System.out.println(w.val);
//            w=w.next;
//        }
        ListNode root2 = swapNodesinPairs.swapPairs(root);
        ListNode t = root2;
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}
