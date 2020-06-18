/**
 * 
 * @author qiuyaoliu
 * iterative way: time : O(N) space : O(1)
 * recursive way: time : O(N) space : O(N)--> n call stack
 *
 */
class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}
public class ReverseLinkedList {
	
	public ListNode reverseLinkedList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			//set the next node's address
			ListNode next = head.next;
			//head point to prev
			head.next = prev;
			//move to the next node, prev to head, head to next
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		//find the last ele in the linkedlist 
		//and set to the head of reverse linkedlist
		ListNode newHead = reverse(head.next); 
		//head.next points to head
		head.next.next = head;
		//head points to null
		head.next = null;
		//return the reversed linkedlist head
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList solution = new ReverseLinkedList();
		
		

	}

}
