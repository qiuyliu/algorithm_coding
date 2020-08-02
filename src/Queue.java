import java.util.*;
import java.lang.*;
import static java.util.Arrays.asList;

public class Queue {
    class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }
    public ListNode head;
    public ListNode tail;
    public Queue() {
        head = tail = null;
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
        return node.value;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public void offer(int ele) {
        if (head == null) {
            head = new ListNode(ele);
            tail = head;
        } else {
            tail.next = new ListNode(ele);
            tail = tail.next;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.offer(1);
        q.offer(3);
        q.offer(5);
        System.out.println(q.peek());
        q.poll();
        System.out.println(q.peek());

        List<Object> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        List<Integer> sub = new ArrayList<>();
        sub.add(3);
        sub.add(4);
        input.add(sub);
        System.out.println(input);
        List<Object> list = asList(asList(1, 2), 3, 4, asList(5, asList(6, 7)));
        List<Object> flatList = flatten(list);
        System.out.println(flatList);
    }

    public static List<Object> flatten(List<Object> input) {
        List<Object> res = new ArrayList<>();
        LinkedList<Object> stack = new LinkedList<>(input);
        while(!stack.isEmpty()) {
            Object e = stack.pop();
            if (e instanceof List<?>) {
                stack.addAll(0, (List<?>)e);
            } else {
                res.add(e);
            }
        }
        return res;
    }

}
