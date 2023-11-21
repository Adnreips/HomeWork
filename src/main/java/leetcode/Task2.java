package leetcode;

import org.apache.maven.shared.utils.xml.PrettyPrintXMLWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
//        l1 = [9]
//        l2 = [1,9,9,9,9,9,9,9,9,9]
        List<Integer> list = List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
//        List<Integer> list = List.of(9, 9, 9, 9, 9, 9, 9);
//        List<Integer> list = List.of(2, 4, 3);
        List<Integer> list2 = List.of(5, 6, 4);
//        List<Integer> list2 = List.of(9, 9, 9, 9);
//        List<Integer> list2 = List.of(5, 6, 4);

        ListNode listNode1 = getListNode(list);
        System.out.println("listNode1 = " + listNode1);
        ListNode listNode2 = getListNode(list2);
        System.out.println("listNode2 = " + listNode2);
        System.out.println(addTwoNumbers(listNode1, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode currentNode = result;
        int dozenCarrier = 0;

        while (pointer1 != null || pointer2 != null) {
            int pointer1Value = (pointer1 == null) ? 0 : pointer1.val;
            int pointer2Value = (pointer2 == null) ? 0 : pointer2.val;
            int sum = pointer1Value + pointer2Value + dozenCarrier;
            dozenCarrier = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            if (pointer1 != null) {
                pointer1 = pointer1.next;
            }
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }
            if (dozenCarrier > 0) {
                currentNode.next = new ListNode(dozenCarrier);
            }
        }
        return result.next;
    }

    private static ListNode getListNode(List<Integer> list) {
        ListNode listNode = null;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == list.size() - 1) {
                listNode = new ListNode(list.get(i));
            } else {
                listNode = new ListNode(list.get(i), listNode);
            }
        }
        return listNode;
    }
}

