import java.util.ArrayList;
import java.util.List;

public class FindAllParenthesis {
    public List<String> findValidParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        helper(n, cur, 0, 0, res);
        return res;
    }

    private void helper(int n, StringBuilder cur, int l, int r, List<String> res) {
        if (l == n && r == n) {
            res.add(new String(cur));
            return ;
        }
        if (l < n) {
            cur.append('(');
            helper(n, cur, l + 1, r, res);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (l > r) {
            cur.append(')');
            helper(n, cur, l, r + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        FindAllParenthesis sol = new FindAllParenthesis();
        System.out.println(sol.findValidParenthesis(3));
    }
}
