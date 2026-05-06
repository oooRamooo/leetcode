public class SwapPairs {
    static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{3, 4, 5});
        SwapPairs swapPairs = new SwapPairs();
        ListNode result = swapPairs.swapPairs(head);
        ListNode.printList(result);
    }

    // Linked List Pointer Manipulation / Dummy Node
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}
