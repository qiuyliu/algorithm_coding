package practices;

import java.util.List;

public class LinkedlistPractice {
    private ListNode head;

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len += 1;
            head = head.next;
        }
        return len;
    }
    public ListNode get(ListNode head, int index) {
        int i = 0;
        while (head != null && i < index) {
            head = head.next;
            i++;
        }
        return head;
    }

    public ListNode appendHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        return newHead;
    }

    public ListNode appendTail(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new ListNode(value);
        return head;
    }

    public ListNode remove(ListNode head, int value) {
//        no duplicated node
        if (head == null) {
            return null;
        } else if (head.val == value) {
            return head.next;
        } else {
            ListNode temp = head;
            while (temp != null && temp.next.val != value) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
//        the list is null or the last node in the linkedlist
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;  // reverse
        head.next = null; // delete the ordinary direction
        return newHead; // need to pass newhead to the top of function call
    }

    private ListNode midPoint(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = midPoint(head).next;
        ListNode tail = head;
        while (tail != null && tail.next != newHead) {
            tail = tail.next;
        }
        tail.next = null;
        newHead = reverse(newHead);
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (head != null && newHead != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = newHead;
            newHead = newHead.next;
            cur = cur.next;
        }
        if (head != null) {
            cur.next = head;
        } else if (newHead != null) {
            cur.next = newHead;
        }
        return dummyHead.next;
    }

    public ListNode partition(ListNode head, int target) {
        if (head == null) {
            return head;
        }
        ListNode dummysmall = new ListNode(0);
        ListNode dummylarge = new ListNode(0);
        ListNode smalltail = dummysmall;
        ListNode largetail = dummylarge;
        while (head != null) {
            if (head.val <= target) {
                smalltail.next = head;
                smalltail = smalltail.next;
            } else {
                largetail.next = head;
                largetail = largetail.next;
            }
            head = head.next;
        }
        smalltail.next = dummylarge.next;
        largetail.next = null;
        return dummysmall.next;
    }

    public static void main(String[] args) {
        LinkedlistPractice lp = new LinkedlistPractice();
        System.out.println(lp.head);
        lp.head = new ListNode(1);
//        lp.head = lp.appendHead(lp.head, 2);
        lp.appendTail(lp.head, 7);
        lp.appendTail(lp.head, 3);
        lp.appendTail(lp.head, 2);
//        System.out.println(lp.head.
//        System.out.println(lp.head.next.val);
//        System.out.println(lp.head.next.next.val);
//        System.out.println(lp.head.next.next.next.val);
//        lp.head = lp.remove(lp.head, 2);
//        System.out.println(lp.head.val);
//        System.out.println(lp.reverse(lp.head).val);
        ListNode n1 = lp.reorder(lp.head);
        System.out.println(n1.val);
        System.out.println(n1.next.val);
        System.out.println(n1.next.next.val);
        System.out.println(n1.next.next.next.val);
        System.out.println(lp.partition(lp.head, 5).val);
    }
}
