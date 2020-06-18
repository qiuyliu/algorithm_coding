import java.util.Arrays;
/**
 * 
 * @author qiuyaoliu
 * time complexity : worst = o(n^2) average = O(nlogn)
 * space: O(logn) logn level for general case
 *
 */
public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	
	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return ;
		}
		//define a pivot and use pivot to partition the array
		int pivot = partition(array, left, right);
		//pivot is not included in any of partitions
		quickSort(array, left, pivot - 1);
		quickSort(array, pivot + 1, right);
		
	}
	
	private int partition(int[] array, int left, int right) {
		int pivotIndex = pivotIndex(left, right);
		int pivotVal = array[pivotIndex];
		//swap the pivot to the rigtmost position first
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivotVal) {
				leftBound++;
			} else if (array[rightBound] >= pivotVal) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		//swap back the pivot
		swap(array, leftBound, right);
		return leftBound;
	}
	private int pivotIndex(int left, int right) {
		return left + (int) (Math.random() * (right - left + 1));
	}
	
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	public static void main(String[] args) {
		QuickSort solution = new QuickSort();
		
		int[] array = null;
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] { 1, 2, 3, 4 };
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] { 2, 5, 3, 1, 4 };
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
	}

}
