import java.util.Arrays;

public class KeepDistance {

    public int[] keepdistance(int k) {
        int[] res = new int[2 * k];
        for (int i = 0; i < k; i++) {
            res[i * 2] = i + 1;
            res[i * 2 + 1] = i + 1;
        }
        boolean[] used = new boolean[k + 1];
        return helper(res, used, 0) ? res : null;
    }

    private boolean helper(int[] res, boolean[] used, int index) {
        if (index == res.length) {
            return true;
        }

        for (int i = index; i < res.length; i++) {
            int cur = res[i];
            if (!used[cur] || (index > cur && res[index - cur - 1] == cur)) {
                swap(res, i, index);
                used[cur] = !used[cur];
                if (helper(res, used, index + 1)) {
                    return true;
                }
                swap(res, i, index);
                used[cur] = !used[cur];
            }
        }

        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        KeepDistance sol = new KeepDistance();
        System.out.println(Arrays.toString(sol.keepdistance(4)));
    }
}
