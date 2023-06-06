package com.changework;

//在原链表的每个节点后面拷贝出一个新的节点
//依次给新的节点的随机指针赋值，而且这个赋值非常容易 cur->next->random = cur->random->next
//断开链表可得到深度拷贝后的新链表
public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {

        if (head==null) {
            return null;
        }
        Node cur = head;
        while (cur!=null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur!=null) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            if(tmp.next!=null) {
                tmp.next = tmp.next.next;
            }
            cur = cur.next;
        }
        return res;
    }
    //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    public static void main(String[] args) {

        // write your code here
        CopyListwithRandomPointer copyListwithRandomPointer =  new CopyListwithRandomPointer();
        Node root = new Node(7);
        Node curr1 = new Node(13);
        root.next= curr1;
        Node curr2 = new Node(11);
        curr1.next = curr2;
        Node curr3 = new Node(10);
        curr2.next = curr3;
        Node curr4 = new Node(1);
        curr3.next = curr4;

//        root.random  = null;
//        curr1.random  = root;
//        curr2.random  = curr3;
//        curr3.random  = curr1;
//        curr4.random  = root;
//        ListNode w = root;
//        while(w!=null){
//            System.out.println(w.val);
//            w=w.next;
//        }
        Node root2 = copyListwithRandomPointer.copyRandomList(root);
        Node t = root2;
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}
