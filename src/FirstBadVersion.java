public class FirstBadVersion {
    public int findFirstBadVersion(boolean[] isBadVersion, int n) {
        if (n < 1) {
            return -1;
        }
        int left = 0, right = n-1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isBadVersion[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (isBadVersion[left]) return left+1;
        if (isBadVersion[right]) return right+1;
        return -1;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        boolean[] arr = new boolean[]{Boolean.FALSE, Boolean.TRUE, Boolean.TRUE};
//        boolean[] arr = new boolean[]{Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
//                Boolean.TRUE, Boolean.TRUE};
        System.out.println(solution.findFirstBadVersion(arr, 3));

    }
}
