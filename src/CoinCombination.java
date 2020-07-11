import java.util.ArrayList;
import java.util.List;

public class CoinCombination {

    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solPrefix = new ArrayList<>();
        combinations(target, coins, 0, solPrefix, res);
        return res;
    }

    private void combinations(int remain, int[] coins, int index, List<Integer> solPrefix, List<List<Integer>> res) {
        if (index == coins.length - 1) {
            if (remain % coins[index] == 0) {
                solPrefix.add(remain / coins[index]);
                res.add(new ArrayList<>(solPrefix));
                solPrefix.remove(solPrefix.size() - 1);
            }
            return ;
        }
        int num = remain / coins[index];
        for (int i = 0; i <= num; i++) {
            solPrefix.add(i);
            combinations(remain - coins[index] * i, coins, index + 1, solPrefix, res);
            solPrefix.remove(solPrefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        CoinCombination sol = new CoinCombination();
        int[] coins = new int[]{25, 10, 4, 1};
        System.out.println(sol.combinations(100, coins));
    }
}
