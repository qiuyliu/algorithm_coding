
public class MinHeap {
	private int[] array;
	private int size;
	
	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
	}
	
	private void heapify() {
		
	}
	
	public MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity can not be <= 0");
		}
		array = new int[cap];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == array.length;
	}
	
	public void offer(int ele) {
		
	}
	private void precolateDown(int index) {
		
	}

}
