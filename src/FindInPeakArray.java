public class FindInPeakArray {
    public int findPeak(int[] input, int target) {
        if (input == null || input.length < 3) {
            return -1;
        }
        int peak = getPeak(input);
        if (input[peak] == target) {
            return peak;
        }
        int res = findTargetAsc(input, 0, peak-1, target);
        if (res != -1) {
            return res;
        }
        return findTargetDesc(input, peak+1, input.length - 1, target);
    }

    private int findTargetAsc(int[] input, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (input[left] == target) return left;
        if (input[right] == target) return right;
        return -1;
    }

    private int findTargetDesc(int[] input, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (input[left] == target) return left;
        if (input[right] == target) return right;
        return -1;
    }

    private int getPeak(int[] input) {
        int left = 0, right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] < input[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return input[left] > input[right] ? left : right;
    }

    public static void main(String[] args) {
        FindInPeakArray solution = new FindInPeakArray();
        int[] a = new int[]{0, 3, 2, 1};
        int[] b = new int[]{3, 4, 6, 2, 1};
        int[] c = new int[]{4, 6, 5, 3, 2};
        int[] d = new int[]{1};
        System.out.println(solution.findPeak(a, 1));
        System.out.println(solution.findPeak(b, 2));
        System.out.println(solution.findPeak(c, 5));
        System.out.println(solution.findPeak(d, 3));
    }
}
