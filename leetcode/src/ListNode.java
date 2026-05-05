public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        for (int value : values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public static void printList(ListNode node) {
        System.out.print("[");

        while (node != null) {
            System.out.print(node.val);
            node = node.next;

            if (node != null) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }

}


