/* 
left -> right: shorten: if digit is '1', do copy; else: newlen += digit-1
right -> left: longer
*/
public class StringDecode {
    public String decompress(String input) {
        // Write your solution here
        if (input == null) {
          return "";
        }
        char[] a = input.toCharArray();
        int slow = 0; //end of return part
        int fast = 0; //position to be processed

        // only process digit [0,2] from left to right
        while (fast < a.length) {
          int digit = isDigit(a[fast + 1]);
          if (digit >= 0 && digit <= 2) {
            for (int i = 0; i < digit; i++) {
              a[slow++] = a[fast];
            }
          } else {
            a[slow++] = a[fast];
            a[slow++] = a[fast + 1];
          }
          fast += 2;
        }
        // check how much len needed to expand for digit in the string
        int newlen = slow;
        for (int i = 0; i < slow; i++) {
          int digit = isDigit(a[i]);
          if (digit > 2 && digit <= 9) {
            newlen += digit - 2;
          }
        }
    
        // process digit in(2, 9] from right to left
        char[] res = new char[newlen];
        int end = newlen - 1;
        int start = slow - 1;
        while (start >= 0) {
          int digit = isDigit(a[start]);
          if (digit > 2 && digit <= 9) {
            start--;
            for (int j = 0; j < digit; j++) {
              res[end--] = a[start];
            }
          } else {
            res[end--] = a[start];
          }
          start--;
        }
        return new String(res);
      }
    
      private int isDigit(char c) {
        return c - '0';
      }

    public static void main(String[] args) {
        StringDecode sd= new StringDecode();
        String input = "a1b2c1";
        System.out.println(sd.decompress(input));
    }
}
