import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class DeduplicateArray {
    public int[] dedup(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }

        int slow = 0;
        boolean flag = false;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[slow] == array[fast]) {
                flag = true;
            } else if (flag == true) {
                array[slow] = array[fast];
                flag = false;
            } else {
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, flag ? slow : slow + 1);
    }

    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] chars = input.toCharArray();
        int s = 0;
        for (int f = 1; f < chars.length; f++) {
            if (s == -1 || chars[f] != chars[s]) {
                chars[++s] = chars[f];
            } else {
                s--;
                while (f + 1 < chars.length && chars[f] == chars[f + 1]) {
                    f++;
                }
            }
        }
        return new String(chars, 0, s + 1);
    }

    public static void main(String[] args) {
        DeduplicateArray solution = new DeduplicateArray();

        int[] input = new int[]{1,1,2,3,3,4,5,5,5};
        int[] input2 = new int[]{1,2,2,1,3};
        String input3 = "aabbabbab";
//        System.out.println(Arrays.toString(solution.dedup(input)));
        System.out.println(solution.deDup(input3));
    }
}
