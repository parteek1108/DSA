
class Solution {
    public void reverseLinkedList(ListNode head) {
        ListNode c = head;
        ListNode p = null;
        ListNode n = null;
        while(c!=null){
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null || left== right) return head;
        ListNode a = null ;
        ListNode b = null ;
        ListNode c = null ;
        ListNode d = null ;
        int pos =1;
        ListNode temp =head;
        while(temp!=null){
            if(left-1 == pos) a = temp;
            if(left == pos) b = temp;
            if(right == pos) c = temp;
            if(right+1 == pos) d = temp;
            pos++;
            temp = temp.next;  
        }
        if(a!=null) a.next = null;
        if(c!=null) c.next = null;
        reverseLinkedList(b);
        if(a!=null) a.next=c;
        b.next=d;
        if(a==null) return c;
        return head;
    }
}