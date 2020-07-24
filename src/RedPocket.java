import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPocket {
    private final int MAXVALUE = 200 * 100;
    private final int MINVALUE = 1;

    public List<Integer> randomDivide(int N, int M) {
        List<Integer> res = new ArrayList<Integer>();
        if (! inRange(N, M)) {
            return res;
        }
        int remainN = N;
        int remainM = M;
        Random random = new Random();
        for (int i = 0; i < M - 1; i++) {
            int amount = random.nextInt(remainN / remainM * 2 - 1) + 1;
            remainN -= amount;
            remainM--;
            res.add(amount);
        }
        res.add(remainN);
        return res;
    }
    private boolean inRange(int money, int count) {
        double avg = money/count;
        if (avg < MINVALUE || avg > MAXVALUE) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RedPocket sol = new RedPocket();
        System.out.println(sol.randomDivide(200, 10));
    }
}
