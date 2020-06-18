import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Hamster {
    public static int[] hamsterTime(String[][] grid) {
        System.out.println(grid);
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length <= 1) {
            return new int[]{-1, -1};
        }
        int row = grid.length, col = grid[0].length;
        int sleep = 0, wake = 0;
        for (int i = 0; i < row; i++) {
            String start = grid[i][0];
            String end = grid[i][1];
            DateFormat format = new SimpleDateFormat("HH:mm");
            Date d1 = null, d2 = null, d3 = null;
            try{
                d1 = format.parse(start);
                d2 = format.parse(end);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long sleepDiff = d2.getTime() - d1.getTime();
            long minutes = TimeUnit.MILLISECONDS.toMinutes(sleepDiff);
            sleep += Math.abs((int)minutes);
            if (i < row-1) {
                String nextSleep = grid[i+1][0];
                try{
                    d3 = format.parse(nextSleep);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long wakeDiff = d2.getTime() - d3.getTime();
                wakeDiff = TimeUnit.MILLISECONDS.toMinutes(wakeDiff);
                wake += Math.abs((int)wakeDiff);
            }
        }
        System.out.println(sleep);
        int[] ans = {sleep, wake};
        return ans;
    }

    public static void main(String[] args) {

        String input =  "1\n"
                        +"\n"
                        +"3\n"
                        +"05:00 06:00\n"
                        +"20:00 08:30\n"
                        +"01:00 01:30\n"
                        +"\n";
        String actual = solve(input);
        System.out.println(actual);

    }
    static String solve(String input){
        Scanner sc = new Scanner(input);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= testCases; ++tc){
            sc.nextLine();
            int N = sc.nextInt();
            String[][] prefs = new String[N][2];
            for(int r = 0; r < N; ++r){
                for(int c = 0; c < 2; ++c){
                    prefs[r][c] = sc.next();
                }
            }
            int[] ans = hamsterTime(prefs);
            sb.append("Case #"+tc+": "+ans[0]+ans[1]+"\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
