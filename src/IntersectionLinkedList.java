public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        ListNode pShort = lenA < lenB ? headA : headB;
        int diff = Math.abs(lenA - lenB);
        ListNode pLong = pShort == headA ? headB : headA;
        while (diff > 0) {
            pLong = pLong.next;
            diff--;
        }
        while (pShort != null && pLong != null) {
            if (pShort == pLong) {
                return pLong;
            }
            pShort = pShort.next;
            pLong = pLong.next;
        }
        return null;
    }
    
    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len += 1;
        }
        return len;
    }

    public static void main(String[] args) {
        
    }
}
