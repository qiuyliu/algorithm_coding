import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public int[] kthSmallest(int[] input, int k) {
        int[] res = new int[k];
        if (input == null || input.length < k) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,
                new Comparator<Integer>() {
            @Override
                    public int compare(Integer a, Integer b) {
                if (a.equals(b)) {
                    return 0;
                }
                return a > b ? -1 : 1;
            }
                });

        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                pq.offer(input[i]);
            } else if (input[i] < pq.peek()){
                pq.poll();
                pq.offer(input[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;

    }

    public static void main(String[] args) {
        KthSmallest sol = new KthSmallest();
        int[] input = new int[]{2,4,1,6,3,5,7};
        System.out.println(Arrays.toString(sol.kthSmallest(input, 4)));
    }
}
