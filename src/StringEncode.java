public class StringEncode {
    public String compress(String input) {
        if (input == null) {
          return "";
        }
        int slow = 0;
        int fast = 0;
        int newLen = 0;
        char[] arr = input.toCharArray();
        while (fast < arr.length) {
          int begin = fast;
          while (fast < arr.length && arr[begin] == arr[fast]) {
            fast++;
          }
          arr[slow++] = arr[begin];
          int count = fast - begin;
          if (count == 1) {
            newLen += 2;
          } else {
            int len = copyDigit(arr, slow, fast - begin);
            slow += len;
            newLen += len + 1;
          }
        }
    
        char[] res = new char[newLen];
        fast = slow - 1;
        slow = newLen - 1;
        while (fast >= 0) {
          if (Character.isDigit(arr[fast])) {
            while (fast >= 0 && Character.isDigit(arr[fast])) {
              res[slow--] = arr[fast--];
            }
          } else {
            res[slow--] = '1';
          }
          // process character
          res[slow--] = arr[fast--];
        }
        return new String(res);
      }
    
      private int copyDigit(char[] input, int index, int count) {
        int len = 0;
        // how many digit needed
        for (int i = count; i > 0; i /= 10) {
          index++;
          len++;
        }
        // put the number in the digit position
        for (int i = count; i > 0; i /= 10) {
          int digit = i % 10;
          input[--index] = (char)('0' + digit);
        }
        return len;
      }
      
      public static void main(String[] args) {
          StringEncode se = new StringEncode();
          String input = "abcd";
          System.out.println(se.compress(input));
      }
}
