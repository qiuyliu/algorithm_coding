public class ReverseString {
    public String reverseWords(String input) {
        // Write your solution here
        char[] arr = input.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
                start = i;
            }
            //check if it gets to the edge first!!!!!
            if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')) {
                reverse(arr, start, i);
            }
        }
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
        ReverseString solution = new ReverseString();

        String yahoo = "i love yahoo";
        String google = "i love google";
        //str = solution.reverseWords(yahoo);
        System.out.println(solution.reverseWords(yahoo));
    }
}
