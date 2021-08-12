import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.isEmpty() || p.length() > s.length()) {
            return res;
        }
        //Build an HashMap containing the count of each char in the p string;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }
        int match = map.size();
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match--;
                }
            }
        }

        if (match == 0) {
            res.add(0);
        }

        int start = 0, end = p.length() - 1;
        while (end < s.length() - 1) {
            char left = s.charAt(start++);
            char right = s.charAt(++end);

            //Increment the counter of each char for each char you remove from the sliding window;
            if (map.containsKey(left)) {
                if (map.get(left) == 0) {
                    match++;
                }
                map.put(left, map.get(left) + 1);
            }
            //start++;

            //Decrement the counter of each char for each char you insert in the sliding window;
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) {
                    match--;
                }
            }

            //If all the char have count==0, that means that the sliding window contains all the chars from the p string.
            if (match == 0) {
                res.add(start);
            }
        }
        return res;

    }
    public static void main(String[] args) {
        Anagram solution = new Anagram();

        String s = "abcabc";
        String p = "ab";
//        System.out.println(Arrays.toString(solution.dedup(input)));
        System.out.println(solution.findAnagrams(s, p));
    }
}
