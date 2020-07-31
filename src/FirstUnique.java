import java.awt.*;
import java.util.*;
import java.util.List;

import static java.util.Arrays.asList;

public class FirstUnique {
    public static int firstUniqChar(String input) {
        // Write your solution here
        if (input == null) {
            return -1;
        }

        char[] chars = input.toCharArray();
        int[] count = new int[256];
        for (char c : chars) {
            count[c]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int findInteger(String input) {
        StringBuilder str = new StringBuilder(input);
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur  < '0' || cur > '9') continue;
            s.add(Integer.parseInt(String.valueOf(cur)));
        }
        return s.size();
    }

    public static int[] dedup(int[] input) {
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

    public static List<Object> flatten(List<Object> input) {
        List<Object> res = new ArrayList<>();
        LinkedList<Object> stack = new LinkedList<>(input);
        while(!stack.isEmpty()) {
            Object e = stack.pop();
            if (e instanceof List<?>) {
                stack.addAll(0, (List<?>)e);
            } else {
                res.add(e);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abbbac";
        String s2 = "ab1ca1b2b";
        int[] input = new int[]{1,2,2,1,4,5,4,3};
        System.out.println(new FirstUnique().firstUniqChar(s1));
        System.out.println(new FirstUnique().findInteger(s2));
        System.out.println(Arrays.toString(new FirstUnique().dedup(input)));
        List<Object> list = asList(asList(1, 2), 3, 4, asList(5, asList(6, 7)));
        List<Object> flatList = flatten(list);
        System.out.println(flatList);
    }
}
