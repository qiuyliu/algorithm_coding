import java.util.*;

public class LAS {
    public List<Integer> longestAscendingSubsequence(int[] input) {
        int[] M = new int[input.length];
        int[] prev = new int[input.length];
        int end_max = 0;

        for (int i = 0; i < input.length; i++) {
            M[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i] && M[i] < M[j] + 1) {
                    M[i] = M[j] + 1;
                    prev[i] = j;
                }
            }
            end_max = M[i] > M[end_max] ? i : end_max;
        }

        List<Integer> res = new ArrayList<>();
        while (end_max >= 0) {
            res.add(input[end_max]);
            end_max = prev[end_max];
        }
        Collections.reverse(res);
        return res;

    }

    public int[] longest(int[] a) {
        // Write your solution here
        if (a == null || a.length == 0) {
            return new int[]{};
        }

        int[] M = new int[a.length];
        int[] prev = new int[a.length];
        int end = 0;

        for (int i = 0; i < M.length; i++) {
            M[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && M[i] < M[j] + 1) {
                    M[i] = M[j] + 1;
                    prev[i] = j;
                }
            }
            end = M[i] > M[end] ? i : end;
        }

        int[] res = new int[M[end]];
        for (int i = res.length-1; i >= 0; --i) {
            res[i] = a[end];
            end = prev[end];
        }

        return res;
    }


    public static void main(String[] args) {
        LAS solution = new LAS();

        int[] input = new int[]{28,4,8,14,14,12,7,14,28,24,9,30,28,29,26,3,17,18,5,29,18,8,30,32,13,29,6};
//        int[] input = new int[]{2,3,7,2,4,5,1,8};
//        int[] input = new int[]{7,2,3,1,5,8,9,6};
//        System.out.println(solution.longestAscendingSubsequence(input));
        System.out.println(Arrays.toString(solution.longest((input))));
    }
}
