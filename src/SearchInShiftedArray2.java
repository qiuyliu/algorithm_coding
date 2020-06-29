public class SearchInShiftedArray2 {
    public int searchInDuplicated(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int left = 0, right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (input[mid] == target) return mid;
            if (input[left] == target) return left;
            if (input[right] == target) return right;

            if ((input[mid] < input[right] && inRange(target, input[mid], input[right])) || (input[mid] > input[left] && ! inRange(target, input[left], input[mid]))) {
                left = mid + 1;
            } else if ((input[mid] < input[right] && ! inRange(target, input[mid], input[right])) || (input[left] < input[mid] && inRange(target, input[left], input[mid]))) {
                right = mid - 1;
            } else {
                left += 1;
                right -= 1;
            }
        }

        if (input[left] == target) return left;
        if (input[right] == target) return right;
        return -1;
    }

    private boolean inRange(int target, int l, int r) {
        return target >= l && target <= r;
    }

    public static void main(String[] args) {
        SearchInShiftedArray2 solution = new SearchInShiftedArray2();
        int[] a = new int[]{3, 1};
        int[] b = new int[]{3, 3, 3, 1, 3};
        int[] c = new int[]{4, 6, 1, 2, 3};
        System.out.println(solution.searchInDuplicated(a, 1));
        System.out.println(solution.searchInDuplicated(b, 1));
        System.out.println(solution.searchInDuplicated(c, 4));
    }
}
