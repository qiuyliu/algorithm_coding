// input is not null, chars only
// using M[i][j] to represent the longest length of common chars in
// the first i chars of A and the first j chars of B
// base case: M[0][0] = 0, M[i][0] = 0, M[0][j] = 0
// induction: M[i][j] = M[i-1][j-1] + 1 if A[i-1] == B[j-1]
// Max(M[i-1][j], M[i][j-1]) otherwise

public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        int[][] longest = new int[source.length() + 1][target.length() + 1];
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i-1) == target.charAt(j-1)) {
                    longest[i][j] = longest[i-1][j-1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i-1][j], longest[i][j-1]);
                }
            }
        }

        return longest[source.length()][target.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        String source = "abcde";
        String target = "cbabdfe";
        System.out.println(solution.longest(source, target));
    }
}
