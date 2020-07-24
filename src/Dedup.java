import java.util.Arrays;

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

    public static void main(String[] args) {
        Dedup sol = new Dedup();
//        int[] input = new int[]{1,2,2};
        String s = "aaab";
        System.out.println(sol.deDup(s));
    }
}
