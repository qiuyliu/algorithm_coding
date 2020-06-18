//input can be null or 0
/*
we maintain an array to record the current favorite fruit of each player and a set to collect the deleted fruit
for deleted fruit:
1. it can be the fruit with lowest votes
2. the lowest same votes fruit with lower index ==> lowest vote with lowest index
 */
import java.util.*;

public class BestFruit {
    static int solve(int[][]prefs){
        if (prefs.length == 0 || prefs == null || prefs[0].length == 0 || prefs[0] == null) {
            return -1;
        }
        int M = prefs.length, N = prefs[0].length;
        //current favorite fruit
        int[] curFav = new int[M];
        //deleted fruit from the poll
        HashSet<Integer> removed = new HashSet<>();
        //each round we let players
        for (int step = 1; step <= N; step++) {
            int[] votes = new int[N+1];
            for (int person = 0; person < M; person++) {
                while (true){
                    int votedFruit = prefs[person][curFav[person]];
                    if (removed.contains(votedFruit)) {
                        curFav[person]++;
                        continue;
                    }
                    if (++votes[votedFruit] > M/2){
                        return votedFruit;
                    }
                    break;
                }
            }
            int delFruit = -1;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= N; ++i){
                if (removed.contains(i)){
                    continue;
                }
                if (votes[i] < min){
                    min = votes[i];
                    delFruit = i;
                }
            }
            removed.add(delFruit);
        }

        return -1;
    }
    static String solve(String input){
        Scanner sc = new Scanner(input);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= testCases; ++tc){
            sc.nextLine();
            int N = sc.nextInt(), M = sc.nextInt();
            int[][] prefs = new int[M][N];
            for(int r = 0; r < M; ++r){
                for(int c = 0; c < N; ++c){
                    prefs[r][c] = sc.nextInt();
                }
            }
            int ans = solve(prefs);
            sb.append("Case #"+tc+": "+ans+"\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        String input =
                "5\n"
                        +"\n"
                        +"3 2\n"
                        +"1 2 3\n"
                        +"2 3 1\n"
                        +"\n"
                        +"4 5\n"
                        +"1 2 3 4\n"
                        +"1 2 3 4\n"
                        +"2 4 3 1\n"
                        +"3 4 2 1\n"
                        +"4 3 2 1\n"
                        +"\n"
                        +"2 1\n"
                        +"2 1\n"
                        +"\n"
                        +"10 10\n"
                        +"1 2 3 4 5 6 7 8 9 10\n"
                        +"2 3 4 5 6 7 8 9 10 1\n"
                        +"3 4 5 6 7 8 9 10 1 2\n"
                        +"4 5 6 7 8 9 10 1 2 3\n"
                        +"5 6 7 8 9 10 1 2 3 4\n"
                        +"6 7 8 9 10 1 2 3 4 5\n"
                        +"7 8 9 10 1 2 3 4 5 6\n"
                        +"8 9 10 1 2 3 4 5 6 7\n"
                        +"9 10 1 2 3 4 5 6 7 8\n"
                        +"10 1 2 3 4 5 6 7 8 9\n"
                        +"\n"
                        +"1 1\n"
                        +"1\n";
        String expected =
                "Case #1: 2\n"
                        +"Case #2: 4\n"
                        +"Case #3: 2\n"
                        +"Case #4: 4\n"
                        +"Case #5: 1\n";
        String actual = solve(input);
        assert actual.equals(expected);
    }
//https://leetcode.com/discuss/interview-question/549128/google-oa-2020-cut-the-cake-best-fruit
/*
M person, N fruit type
each person has a permutation of the N fruit type, denoting preference order
there will be at most N-1 voting rounds, each fruit with least votes (or lower index for tie breaking) is eliminated
result: which fruit is the best

*/
}
