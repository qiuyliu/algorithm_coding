import java.util.Arrays;

public class RaindowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length < 1) {
            return new int[]{};
        }

        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, j++, i++);
            } else if (array[j] == 0) {
                j++;
            } else {
                swap(array, j, k--);
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        RaindowSort solution = new RaindowSort();

        int[] array = null;
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[0];
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1, -1, 1, 0 };
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 0, 0, 1, 1, -1 };
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }

}
