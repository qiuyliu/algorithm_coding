import java.util.Arrays;

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

    public static void main(String[] args) {
        DeduplicateArray solution = new DeduplicateArray();

        int[] input = new int[]{1,1,2,3,3,4,5,5,5};
        int[] input2 = new int[]{1,2,2,1,3};
        System.out.println(Arrays.toString(solution.dedup(input)));
    }
}
