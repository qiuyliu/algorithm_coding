public class RightShiftByN {
    public String rightShift(String input, int n) {
        // Write your solution here
        if (input.length() <= 1) {
            return input;
        }
        char[] arr = input.toCharArray();
        n %= arr.length;
        reverse(arr, arr.length - n, arr.length - 1);
        reverse(arr, 0, arr.length - n - 1);
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RightShiftByN solution = new RightShiftByN();
        String str = "abcdef";
        System.out.println(solution.rightShift(str, 2));
    }
}
