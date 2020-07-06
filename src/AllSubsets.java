import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
    public List<String> allSubsets(String set) {
        List<String> res = new ArrayList<String >();
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
            return ;
        }

        findSubset(setArr, index + 1, prefix, res);

        findSubset(setArr, index + 1, prefix.append(setArr[index]), res);
        prefix.deleteCharAt(prefix.length() - 1);
    }

    public static void main(String[] args) {
       AllSubsets sol = new AllSubsets();
       String set = "abc";
        System.out.println(sol.allSubsets(set));
    }
}
