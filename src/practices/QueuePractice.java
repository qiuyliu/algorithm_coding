package practices;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class QueuePractice {
    private ListNode head;
    private ListNode tail;

    public QueuePractice() {
        head = tail = null;
    }
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        node.next = null;
        return node.val;
    }

    public void offer(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public static void main(String[] args) {
        QueuePractice qp = new QueuePractice();
        qp.offer(1);
        qp.offer(3);
        qp.poll();
        System.out.println(qp.peek());
        qp.offer(2);
        System.out.println(qp.head.val);
        System.out.println(qp.tail.val);
    }
}
