import java.util.Scanner;

public class CutCake {
    static int solve(int[][]grid,int K){
        int R = grid.length, C = R == 0 ? 0 : grid[0].length;
        int[][] ones = new int[R+1][C+1];
        //
        for(int r = R-1; r >= 0; --r){
            for(int c = C-1; c >= 0; --c){
                ones[r][c] = grid[r][c]+ones[r+1][c]+ones[r][c+1]-ones[r+1][c+1];
            }
        }

        int[][] dp = new int[R][C];
        for(int r = 0; r < R; ++r){
            for(int c = 0; c < C; ++c){
                dp[r][c] = ones[r][c] == 0 ? 0 : 1;
            }
        }

        for(int cut = 1; cut < K; ++cut){
            int[][] nextDp = new int[R][C];
            for(int startR = R-1; startR >= 0; --startR){
                for(int startC = C-1; startC >= 0; --startC){
                    //cut horizontally
                    for(int cutR = startR; cutR < R-1; ++cutR){
                        //nextDp[startR][startC] += ((ones[startR][startC]-ones[cutR+1][startC]) == 0 ? 0 : 1) * dp[cutR+1][startC];
                        if (ones[startR][startC] > ones[cutR+1][startC]) {
                            nextDp[startR][startC] += dp[cutR+1][startC];
                        }
                    }
                    //cut vertically
                    for(int cutC = startC; cutC < C-1; ++cutC){
                        //nextDp[startR][startC] += ((ones[startR][startC]-ones[startR][cutC+1]) == 0 ? 0 : 1) * dp[startR][cutC+1];
                        if (ones[startR][startC] > ones[startR][cutC+1]) {
                            nextDp[startR][startC] += dp[startR][cutC+1];
                        }
                    }
                }
            }
            dp = nextDp;
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        String input =
                "9\n"
                        +"\n"
                        +"2 2 3\n"
                        +"11\n"
                        +"11\n"
                        +"\n"
                        +"3 3 3\n"
                        +"111\n"
                        +"100\n"
                        +"100\n"
                        +"\n"
                        +"4 4 4\n"
                        +"0001\n"
                        +"0001\n"
                        +"0001\n"
                        +"0001\n"
                        +"\n"
                        +"4 4 2\n"
                        +"0001\n"
                        +"0001\n"
                        +"0001\n"
                        +"0001\n"
                        +"\n"
                        +"4 4 2\n"
                        +"0001\n"
                        +"0000\n"
                        +"0000\n"
                        +"0001\n"
                        +"\n"
                        +"4 4 4\n"
                        +"1000\n"
                        +"0100\n"
                        +"0010\n"
                        +"0001\n"
                        +"\n"
                        +"4 4 4\n"
                        +"0001\n"
                        +"0010\n"
                        +"0100\n"
                        +"1000\n"
                        +"\n"
                        +"1 10 5\n"
                        +"1111111111"
                        +"\n"
                        +"10 10 5\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n"
                        +"1111111111\n";
        String expected =
                "Case #1: 2\n"
                        +"Case #2: 2\n"
                        +"Case #3: 1\n"
                        +"Case #4: 3\n"
                        +"Case #5: 3\n"
                        +"Case #6: 8\n"
                        +"Case #7: 8\n"
                        +"Case #8: 126\n"
                        +"Case #9: 14076\n";
        String actual = solve(input);
        System.out.println(actual);
        assert actual.equals(expected);

    }
    static String solve(String in){
        Scanner sc = new Scanner(in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= testCases; ++tc){
            int H = sc.nextInt(), W = sc.nextInt(), K = sc.nextInt();
            sc.nextLine();
            int[][] grid = new int[H][W];
            for(int r = 0; r < H; ++r){
                String line = sc.nextLine();
                for(int c = 0; c < W; ++c){
                    grid[r][c] = line.charAt(c)-'0';
                }
            }
            int solution = solve(grid,K);
            sb.append("Case #"+tc+": "+solution+"\n");
        }
        return sb.toString();
    }
}
