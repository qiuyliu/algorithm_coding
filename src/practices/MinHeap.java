package practices;

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
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capcaity can not be <= 0");
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

    public void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    public void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftchildIndex = index * 2 + 1;
            int rightchildIndex = index * 2 + 2;
            int smallerchild = leftchildIndex;

            if (rightchildIndex < size  && array[rightchildIndex] < array[leftchildIndex]) {
                smallerchild = rightchildIndex;
            }

            if (array[index] > array[smallerchild]) {
                swap(array, index, smallerchild);
            } else {
                break;
            }
            index = smallerchild;
        }

    }

    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("the heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException("the heap is empty");
        }
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public void offer(int ele) {
        if (size == array.length) {
            int[] newArray = new int[(int) (array.length * 1.5)];
            copy(array, newArray);
            array = newArray;
        }
        array[size] = ele;
        size++;
        percolateUp(ele);
    }

//    update the element at index to a given new value
    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int res = array[index];
        array[index] = ele;
        if (res > ele) {
            percolateUp(ele);
        } else {
            percolateDown(ele);
        }
        return res;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    private void copy(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,11,7,2,8,4,6,13,3};
        MinHeap mh = new MinHeap(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
