import java.io.*;
import java.nio.charset.StandardCharsets;

// public class StockTracker {
//     public static void main(String[] args) throws IOException{
//         InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//         BufferedReader in = new BufferedReader(reader);
//         String line;
//         while ((line = in.readLine()) != null) {
//             System.out.println(line);
//         }
//     }
// }

public class StockTracker {
    public int minDifference(int[] array) {
    // Write your solution here
        int[] minDiff = new int[]{Integer.MAX_VALUE};
        int levelLeft = array.length / 2; // 3 -> 1; 4 -> 2
        int totalSum = 0;
        for (int i : array) {
            totalSum += i;
        }
        int selectRange = array.length - levelLeft; // 3 -> 2; 4 -> 2
        
        dfs(array, minDiff, levelLeft, totalSum, 0, 0, selectRange);
        
        return minDiff[0];
    }
    
    private void dfs (int[] array, int[] minDiff, int levelLeft, int totalSum,
        int currSum, int beginIdx, int selectRange) {
        if (levelLeft == 0) {
            minDiff[0] = Math.min(minDiff[0], Math.abs(totalSum - currSum - currSum));
            return;
        }

        for (int i = beginIdx; i < array.length && i <= beginIdx + selectRange; i++) {
            currSum += array[i];
            dfs(array, minDiff, levelLeft - 1, totalSum, currSum, i + 1, selectRange);
            currSum -= array[i];
        }
        } // end dfs
    }
    
    
