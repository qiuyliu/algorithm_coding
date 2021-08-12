package practices;


public class StackPractice {
    private ListNode head;

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    public Integer pop() {
        if (head ==  null) {
            return null;
        }
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        return prev.val;
    }

    public void push(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

    public static void main(String[] args) {
        StackPractice sp = new StackPractice();
        sp.push(1);
        sp.push(3);
        sp.push(2);
        System.out.println(sp.peek());
        sp.pop();
        System.out.println(sp.head.val);
    }
}
