import java.util.LinkedList;

public class Stack {


	class ListNode {
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
//	implement stack
	private ListNode head;

	public Integer pop() {
		if (head == null) {
			return null;
		}
		ListNode prev = head;
		head = head.next;
		prev.next = null;
		return head.value;

	}

	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}

	public void push(int ele) {
		ListNode newHead = new ListNode(ele);
		newHead.next = head;
		head = newHead;
	}

//	Two Stack sort
	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		if (s1 == null || s1.size() <= 1) {
			return ;
		}
		sort(s1, s2);
	}

	private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2) {
		while (!s1.isEmpty()) {
			int curMin = Integer.MAX_VALUE;
			int count = 0;
			while (!s1.isEmpty()) {
				int cur = s1.pollFirst();
				if (cur < curMin) {
					curMin = cur;
					count = 1;
				} else if (cur == curMin) {
					count++;
				}
				s2.offerFirst(cur);
			}
			while (!s2.isEmpty() && s2.peekFirst() >= curMin) {
				int pop = s2.pollFirst();
				if (pop != curMin) {
					s1.offerFirst(pop);
				}
			}
			while (count > 0) {
				s2.offerFirst(curMin);
				count--;
			}
		}
		while (!s2.isEmpty()) {
			s1.offerFirst(s2.pollFirst());
		}
	}

	public static void main(String[] args) {
		Stack stackSort = new Stack();
		LinkedList<Integer> s1 = new LinkedList<>();
		s1.add(2);
		s1.add(5);
		s1.add(1);
		s1.add(3);
		s1.add(4);
		stackSort.sort(s1);
		System.out.println(s1);
	}

}

