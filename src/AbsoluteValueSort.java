import java.util.Arrays;

public class AbsoluteValueSort {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quicksort(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }
        int pivot = partition(arr, left, right);

        quicksort(arr, left, pivot - 1);
        quicksort(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivotIdx = right;
        int pivotval = arr[pivotIdx];

        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (Math.abs(arr[leftBound]) < Math.abs(pivotval)
            || (Math.abs(arr[leftBound]) == Math.abs(pivotval) && arr[leftBound] < pivotval)) {
                leftBound++;
            } else if (Math.abs(arr[rightBound]) > Math.abs(pivotval)
            || (Math.abs(arr[rightBound]) == Math.abs(pivotval) && arr[rightBound] >= pivotval)) {
                rightBound--;
            } else {
                swap(arr, leftBound++, rightBound--);
            }
        }
        swap(arr, leftBound, right);
        return leftBound;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        AbsoluteValueSort sol = new AbsoluteValueSort();
        int[] input = new int[]{2, -7, -2, -2, 0, 7};
        System.out.println(Arrays.toString(sol.sort(input)));
    }
}
