import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TwoSum {
//    hashset: time O(n) + space O(n)
    public boolean twoSum(int[] input, int target) {
        if (input == null || input.length < 2) {
            return false;
        }
        HashSet<Integer> s = new HashSet<>();
        for (int num : input) {
            if (s.contains(target - num)) {
                return true;
            } else {
                s.add(num);
            }
        }
        return false;
    }
//    heapsort + sliding window: time O(nlogn) + space O(1)
    public boolean twoSumInUnsorted(int[] input, int target) {
        if (input == null || input.length < 2) {
            return false;
        }
        int[] sortedInput = heapSort(input);
        int l = 0, r = sortedInput.length-1;
        while (l < r) {
            int sum = sortedInput[l] + sortedInput[r];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    private int[] heapSort(int[] input) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                input.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            minHeap.offer(input[i]);
        }
        int[] res = new int[input.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] input = new int[]{2, 1, 4, -1, 3};
        System.out.println(solution.twoSum(input, 2));
        System.out.println(solution.twoSumInUnsorted(input, -1));
    }
}
