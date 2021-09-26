public class NumberPaths {

  static int paths(int n) {
    // your code goes here
    if (n < 1) {
      return 0;
    }
    int[] count = new int[1];
    helper(n - 1, 0, 0, count);
    return count[0];
  }
  private static void helper(int n, int i, int j, int[] count) {
      //base case
      if (i == n && j == n) {
          count[0]++;
          return ;
      }
      
      if (i < n && j < n) {
          if (i > j) {
              helper(n, i, j + 1, count);
          }
          helper(n, i + 1, j, count);
      } else if (j < n) {
          helper(n, i, j + 1, count);
      }
  }

    public static void main(String[] args) {
        NumberPaths np = new NumberPaths();
        System.out.println(np.paths(5));
    }
}
