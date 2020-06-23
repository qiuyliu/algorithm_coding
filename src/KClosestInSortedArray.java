import java.util.Arrays;

public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        int[] res = new int[k];
        if (array == null || array.length == 0 || k == 0) {
            return res;
        }
        int cloestIdx = binarySearch(array, target);
        int i = 0;
        res[i++] = array[cloestIdx];
        int left = cloestIdx - 1;
        int right = cloestIdx + 1;


        while (i < k) {
            if (right >= array.length || (left >= 0 && Math.abs(target - array[left]) <= Math.abs(target - array[right]))) {
                res[i++] = array[left--];
            } else {
                res[i++] = array[right++];
            }
        }
        return res;
    }

    private int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(target - array[left]) <= Math.abs(target - array[right])) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        KClosestInSortedArray solution = new KClosestInSortedArray();
        int[] input = new int[]{1, 3, 5};
        System.out.println(Arrays.toString(solution.kClosest(input, 10, 3)));
    }
}
