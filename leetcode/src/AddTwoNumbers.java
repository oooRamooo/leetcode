public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = createList(new int[] {2, 4, 3});
        ListNode l2 = createList(new int[] {5, 6, 4});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        printList(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null ||carry != 0){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum /10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummyHead.next;

    }

    private static ListNode createList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        for (int value : values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    private static void printList(ListNode node) {
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



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


