import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class MinDiffPoints {
    public int[] mindiff(int[][] input) {
        // invalid input
        if (input == null || input.length == 0 || input[0].length == 0) {
            return new int[2];
        }
        // sort
        sort(input);
        // find min and max and insert into map
        HashMap<int[], Integer> map = new HashMap<>();
        for (int[] cur : input) {
            int len = cur.length;
            int diff = Math.abs(cur[0] - cur[len - 1]); 
            map.put(new int[]{cur[0], cur[len - 1]}, diff);
        }
        // use heap to sort diff
        PriorityQueue<Map.Entry<int[], Integer>> min = new PriorityQueue<>(
            input.length, new Comparator<Map.Entry<int[], Integer>>(){
                @Override
                public int compare(Map.Entry<int[], Integer> a, Map.Entry<int[], Integer> b) {
                    if (a.getValue().equals(b.getValue())) {
                        return 0;
                    }
                    return a.getValue() < b.getValue() ? -1 : 1;
                }
            });
    
        for (Map.Entry<int[], Integer> e : map.entrySet()) {
            min.add(e);
        }

        return min.peek().getKey();
    }

    private void sort(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            Arrays.sort(input[i]);
        }
    }

    public static void main(String[] args) {
        MinDiffPoints mdp = new MinDiffPoints();
        int[][] input = new int[][]{
            {3, 2, 0},
            {2, 7, 9},
            {-1, 0, -2}
        };
        int[] res = mdp.mindiff(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
