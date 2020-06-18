//time complexity: O(H*W*K*(H+W))
//Space complexity: O(H*W)
/*
The input can't be null or 0

we maintain a matrix to collect the No. of strawberry in each rectangular from top left to bottom right that can get
we initialize the array to collect the position that can get at least strawberry and based on that to cut
we check for valid cut from i->0, j->0.
we can cut out/get ride of part that have at least one strawberry ==> current position have more count than right and lower side
we can cut on column k if count[i][j] > count[i][k+1]
we can cut on row k if count[i][j] > count[k+1][j]

But remember that whenever we make a cut we need to ensure that the part cut out should at least have a single strawberry.
To ensure this we need to do some precomputation on the cake.
Let staw[i][j] denotes the number of strawberry in the part of the cake from the ith row and the jth column.

Now let's say that we make a cut on the kth column so the part of the cake we get from it is cake[i][j] to cake[i][k] the staw[i][j] > staw[i][k+1] because now the part of cake from cake[i][j] to cake[i][k] will have at least one strwaberry.
Similarly, if we made a row cut cake[i][j] to cake[k][j] then
staw[i][j] > staw[k+1][j].
 */
import java.util.Scanner;

public class CutTheCake {
    public static int cut(int[][] grid, int k) {
        if(grid.length == 0 || grid[0].length == 0 || grid == null || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        int[][] berryCount = new int[row+1][col+1];
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                berryCount[i][j] = grid[i][j] + berryCount[i+1][j] + berryCount[i][j+1] - berryCount[i+1][j+1];
            }
        }
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (berryCount[i][j] != 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int c = 1; c < k; c++) {
            int[][] next = new int[row][col];
            for (int curRow = row-1; curRow >= 0; curRow--) {
                for (int curCol = col-1; curCol >= 0; curCol--) {
                    //check horizontal cut
                    for (int cutRow = curRow; cutRow < row-1; cutRow++) {
                        //only add on if the cut out part have at least one berry
                        //we check the berry count if current position have more count than the cut+1 position
                        if (berryCount[curRow][curCol] > berryCount[cutRow+1][curCol]) {
                            next[curRow][curCol] += dp[cutRow+1][curCol];
                        }
                    }
                    //check vertical cut
                    for (int cutCol = curCol; cutCol < col-1; cutCol++) {
                        //same as the horizontal, we only cut if the cut out part have at least one strawberry
                        //if current position have more count than the cut+1 position
                        if (berryCount[curRow][curCol] > berryCount[curRow][cutCol+1]) {
                            next[curRow][curCol] += dp[curRow][cutCol+1];
                        }
                    }
                }
            }
            dp = next;
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
        /*
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

         */
        String actual = cut(input);
        System.out.println(actual);
        //assert actual.equals(expected);
    }

    static String cut(String in){
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
            int solution = cut(grid,K);
            sb.append("Case #"+tc+": "+solution+"\n");
        }
        return sb.toString();
    }
}
