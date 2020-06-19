public class CuttingRope {
    public int maxProduct(int length) {
        //corner case n < 2
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;

        for (int i = 2; i <= length; i++) {
            M[i] = 0;
            for (int j = 1; j < i; j++) {
                M[i] = Math.max(M[i], Math.max(j, M[j]) * (i - j));
            }
        }
        return M[length];
    }

    public static void main(String[] args) {
        CuttingRope solution = new CuttingRope();
        System.out.println(solution.maxProduct(6));
    }
}
