class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;

        // kth node from beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode fast = first;
        ListNode second = head;

        // kth node from end
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
