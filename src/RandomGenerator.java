public class RandomGenerator {
    int[] presum;

    public RandomGenerator(int[] w) {
        presum = new int[w.length];
        presum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            presum[i] = presum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        double picked = presum[presum.length - 1] * Math.random();
        int left = 0, right = presum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (presum[mid] > picked) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] w = new int[]{1,3};
        RandomGenerator sol = new RandomGenerator(w);
        System.out.println(sol.pickIndex());
        System.out.println(sol.pickIndex());
        System.out.println(sol.pickIndex());    
        System.out.println(sol.pickIndex());        
        System.out.println(sol.pickIndex());   
        System.out.println(130 < 'y');    

    }
}