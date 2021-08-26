import java.util.*;

public class AllPermutations {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        char[] inputArr = input.toCharArray();

        // permutation(inputArr, 0, res);
        permutations(inputArr, 0, res);
        return res;
    }

    private void permutation(char[] inputArr, int index, List<String> res) {
        if (index == inputArr.length) {
            res.add(new String(inputArr));
            return ;
        }

        for (int i = index; i < inputArr.length; i++) {
            swap(inputArr, index, i);
            permutation(inputArr, index + 1, res);
            swap(inputArr, index, i);
        }
    }

    private void permutations(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
          res.add(new String(chars));
          return ;
        }
        Set<Character> s = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
          if (s.contains(chars[i])) {
            continue;
          }
          s.add(chars[i]);
          swap(chars, index, i);
          permutations(chars, index + 1, res);
          swap(chars, index, i);
        }
      }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        AllPermutations sol = new AllPermutations();
        String input = "abc";
        String dupInput = "aab";
        // System.out.println(sol.permutations(input));
        System.out.println(sol.permutations(dupInput));
    }
}
