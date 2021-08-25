package practices;

import java.util.*;

public class StringReplace {
    public String replace(String input, String source, String target) {
        // Write your solution here
        if (input == null || input.length() == 0 || source == null || target == null) {
          return "";
        }
    
        char[] inputArr = input.toCharArray();
        if (source.length() < target.length()) {
          return replaceLarger(inputArr, source, target);
        }
        return replaceShorter(inputArr, source, target);
      }
      private String replaceShorter(char[] input, String source, String target) {
        int slow = 0, fast = 0;
        while (fast < input.length) {
          if (fast <= input.length - source.length() && equalPattern(input, fast, source)) {
            copyTarget(input, slow, target);
            slow += target.length();
            fast += source.length();
          } else {
            input[slow++] = input[fast++];
          }
        }
        return new String(input, 0, slow);
      }

      private String replaceLarger(char[] input, String source, String target) {
          ArrayList<Integer> matches = getAllMateches(input, source);
          char[] res = new char[input.length + matches.size() * (target.length() - source.length())];
          int fast = input.length - 1;
          int slow = res.length - 1;
          int lastIdx = matches.size() - 1;
          while (fast >= 0) {
              if (lastIdx >= 0 && fast == matches.get(lastIdx)) {
                  copyTarget(res, slow - target.length() + 1, target);
                  slow -= target.length();
                  fast -= source.length();
                  lastIdx--;
              } else {
                  res[slow--] = input[fast--];
              }
          }
          return new String(res);
      }

    //   get all matches' end position
      private ArrayList<Integer> getAllMateches(char[] input, String source) {
          ArrayList<Integer> res = new ArrayList<>();
          int i = 0;
          while (i <= input.length - source.length()) {
              if (equalPattern(input, i, source)) {
                  res.add(i + source.length() - 1);
                  i += source.length();
              } else {
                  i++;
              }
          }
          return res;
      }
    
      private boolean equalPattern(char[] arr, int index, String s) {
        for (int i = 0; i < s.length(); i++) {
          if (arr[index + i] != s.charAt(i)) {
            return false;
          }
        }
        return true;
      }
    
      private void copyTarget(char[] arr, int index, String t) {
        for (int i = 0; i < t.length(); i++) {
          arr[index + i] = t.charAt(i);
        }
      }

      public static void main(String[] args) {
        StringReplace sol = new StringReplace();
        System.out.println(sol.replace("tywjtltyvtyegcboycmqtyq","ty","c"));
    }
}
