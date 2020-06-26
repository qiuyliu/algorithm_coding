import java.util.Arrays;
/*
    the part which is not absolute ascending contain the shifted pivot index
    if left is absolute ascending and target is in left
    or if right is absolute ascending but target is not in right : go left
    otherwise: go right
 */
public class SearchInShiftedArray {

    public int searchTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if ((array[left] < array[mid] && inRange(target, array[left], array[mid])) ||
                    (array[mid] < array[right] && !inRange(target, array[mid], array[right]))) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;
    }

    private boolean inRange(int target, int l, int r) {
        return target >= l && target <= r;
    }

    public static void main(String[] args) {
        SearchInShiftedArray solution = new SearchInShiftedArray();
        int[] a = new int[]{3, 5, 7, 1, 2};
        int[] b = new int[]{1, 2, 3, 5, 7};
        int[] c = new int[]{4, 6, 1, 2, 3};
        System.out.println(solution.searchTarget(a, 5));
        System.out.println(solution.searchTarget(b, 5));
        System.out.println(solution.searchTarget(c, 4));
    }
}
