//Suppose we already implemented dictionary
interface Dictionary {
    public Integer get(int index);
}
public class SearchInUnknownSize {
    public int search(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0, right = 1;
        while (dict.get(0) != null && dict.get(right) < target) {
            left = right;
            right *= 2;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) != null && dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
