import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets {
    public List<String> allSubsets(String set) {
        List<String> res = new ArrayList<String>();
        if (set == null) {
            return res;
        }
        char[] setArr = set.toCharArray();
        StringBuilder prefix = new StringBuilder();
        findSubset(setArr, 0, prefix, res);
        return res;
    }

    private void findSubset(char[] setArr, int index, StringBuilder prefix, List<String> res) {
        if (index == setArr.length) {
            res.add(prefix.toString());
            return;
        }

        findSubset(setArr, index + 1, prefix, res);

        findSubset(setArr, index + 1, prefix.append(setArr[index]), res);
        prefix.deleteCharAt(prefix.length() - 1);
    }

    public List<String> subSets(String set, int k) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null || set.length() < k) {
            return res;
        }
        char[] chars = set.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        subset(chars, k, 0, sb, res);
        return res;
    }

    private void subset(char[] chars, int k, int i, StringBuilder sb, List<String> res) {
        if (i == chars.length) {
            if (sb.length() <= k) {
                res.add(sb.toString());
            }
            return;
        }
        if (sb.length() > k) return;

        sb.append(chars[i]);
        subset(chars, k, i + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        int nextIdx = i;
        while (nextIdx < chars.length && chars[nextIdx] == chars[i]) {
            nextIdx++;
        }
        subset(chars, k, nextIdx, sb, res);
    }


    public static void main(String[] args) {
        AllSubsets sol = new AllSubsets();
        String set = "abc";
        String set2 = "aab";
        String a = new String(set);
        System.out.println(sol.allSubsets(set));
//        System.out.println(sol.subSets(set2, 2));
    }
}
