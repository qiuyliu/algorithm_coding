import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dedup {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 1, j = 1;
        while (j < array.length) {
            if (array[i - 1] == array[j]) {
                while (array[i - 1] == array[j]) {
                    if (j == array.length - 1) {
                        return "";
                    }
                    j++;
                }
                i--;
            } else {
            array[i++] = array[j++];
            }
        }
        System.out.println("a");
        return new String(array, 0, i);
    }

    public static int[] dedup2(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int s = 0;

        for (int f = 0; f < array.length; f++) {
            if (array[f] != array[s]) {
                array[++s] = array[f];
            }
        }

        return Arrays.copyOf(array, s + 1);
    }

    public static int[] dedup3(int[] input) {
        int[] array = heapSort(input);
        int s = 0;

        for (int f = 0; f < array.length; f++) {
            if (array[f] != array[s]) {
                array[++s] = array[f];
            }
        }

        return Arrays.copyOf(array, s + 1);
    }

    private static int[] heapSort(int[] input) {
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
        for (Integer i : input) {
            minHeap.offer(i);
        }

        int[] res = new int[input.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Dedup sol = new Dedup();
        int[] input = new int[]{1,2,2};
        String s = "aaab";
//        System.out.println(sol.deDup(s));
        System.out.println(Arrays.toString(sol.dedup2(input)));
        int[] input2 = new int[]{1,2,2,1,4,5,4,3};
        System.out.println(Arrays.toString(new Dedup().dedup3(input2)));
    }
}
