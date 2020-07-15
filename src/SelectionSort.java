import java.util.Arrays;

public class SelectionSort {
	public int[] selectionSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
		return array;
		
	}
	
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		SelectionSort solution = new SelectionSort();
		
		int[] array = null;
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1,2,3,4};
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));

	}

}
