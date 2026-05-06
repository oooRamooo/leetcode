import java.util.PriorityQueue;

public class MergeKList {
    static void main(String[] args) {
        ListNode[] list = new ListNode[2];
        list[0] = ListNode.createList(new int[]{1, 2, 3, 4, 5, 7});
        list[1] = ListNode.createList(new int[]{3, 4, 5});
        MergeKList mergeKList = new MergeKList();
        ListNode.printList(mergeKList.mergeKLists(list));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();

            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }

        return dummy.next;


    }
}
