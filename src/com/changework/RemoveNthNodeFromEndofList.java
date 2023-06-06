package com.changework;


//采取双重遍历肯定是可以解决问题的，但题目要求我们一次遍历解决问题，那我们的思路得发散一下。
//我们可以设想假设设定了双指针p和q的话，当q指向末尾的NULL，p与q之间相隔的元素个数为n时，那么删除掉p的下一个指针就完成了要求。
//设置虚拟节点dummyHead指向head
//设定双指针p和q，初始都指向虚拟节点dummyHead
//移动q，直到p与q之间相隔的元素个数为n
//同时移动p与q，直到q指向的为NULL
//将p的下一个节点指向下下个节点
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for(int i=0;i<n+1;i++){
            q=q.next;
        }
        while(q!=null){
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {

        // write your code here
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList =  new RemoveNthNodeFromEndofList();
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
        ListNode root2 = removeNthNodeFromEndofList.removeNthFromEnd(root,2);
        ListNode t = root2;
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}
