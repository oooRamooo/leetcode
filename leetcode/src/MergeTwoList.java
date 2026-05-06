public class MergeTwoList {

    static void main(String[] args) {
        MergeTwoList s = new MergeTwoList();
        ListNode ans = s.mergeTwoLists(ListNode.createList(new int[]{1, 3, 4, 5}), ListNode.createList(new int[]{1, 2, 3, 4, 5}));
        ListNode.printList(ans);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummyHead.next;
    }
}
