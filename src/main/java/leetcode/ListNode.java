package leetcode;

public class ListNode {
    int val;
    private String result = "[";

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }

    @Override
    public String toString() {
        return forToString(this);
    }

    String forToString(ListNode listNode) {
        result = result.concat(String.valueOf(listNode.val));
        if (listNode.next == null) {
            return result.concat("]");
        }
        result = result.concat(", ");
        listNode = listNode.next;
        return forToString(listNode);
    }

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
}
