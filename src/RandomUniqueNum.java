import java.util.*;


public class RandomUniqueNum {
    // private List<Integer> nums; // original array
    private int[] nums;
    private Random rand;
    private int capacity;   // original array length
    private int index;  // index to track on shuffled array
    // private List<Integer> shuffled; // shuffled array for random number
    private int[] shuffled;
    private Set<Integer> black;   // used number


    public RandomUniqueNum(int[] range) {
        int len = range[1] - range[0] + 1;
        // this.nums = new ArrayList<>();
        // this.capacity = nums.size();
        this.nums = new int[len];
        this.capacity = nums.length;

        this.rand = new Random();
        // this.shuffled = new ArrayList<>();

        this.black = new HashSet<>();
        for (int i = 0; i < len; i++, range[0]++) {
            // nums.add(range[0]);
            nums[i] = range[0];
        }
        // shuffle and copy to another list

        shuffled = shuffle(nums);
    }
    private void updateRange(int[] range) {
        if (nums[0] == range[0] && nums[nums.length - 1] == range[1]) {
            return ;
        }
        // if (nums.get(nums.size() - 1) < range[0] || range[1] < nums.get(0)) {
        //     // no overlap
        //     int prelen = nums.size();
        //     nums = Arrays.copyOf(nums, prelen + range[1] - range[0] + 1);
        //     for (int i = prelen - 1; i < nums.length; i++, range[0]++) {
        //         nums[i] = range[0];
        //     }
        // } else {
        //     int new_len = 0;
        //     for (int i = range[0]; i < range[1]; i++) {
        //         if (black.contains(i) || (i > nums[0] && i < nums[nums.length - 1])) {
        //             continue ;
        //         }

        //         new_len++;
        //     }
        // }
        // for (int i = range[0]; i < range[1]; i++) {
        //     if (black.contains(i) || nums.contains(i)) {
        //         continue;
        //     } 
        //     nums.add(i);
        // }
        for (int i = range[0]; i < range[1]; i++) {
            if (black.contains(i)) {
                continue ;
            }
        }    
        shuffled = shuffle(nums);

    }

    public int nextRandom() { // average O(1) - when shuffle needed O(n)
        if (index == capacity) {
            shuffled = shuffle(shuffled);
            index = 0;
        }
        // black.add(shuffled.get(index));
        // return shuffled.get(index++);
        black.add(shuffled[index]);
        return shuffled[index++];
    }

    // private List<Integer> shuffle(List<Integer> nums) { // O(n)
    private int[] shuffle(int[] nums) {
        // for (int i = nums.size() - 1; i > 0; i--) {
        for (int i = nums.length - 1; i > 0; i--) {
            int randIdx = rand.nextInt(i + 1);
            if (randIdx != i) {
                swap(nums, i, randIdx);
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    // if given new range how should we pick the random number that is unique from before




    public static void main(String[] args) {
        int[] range = new int[]{1, 9};
        RandomUniqueNum ru = new RandomUniqueNum(range);
        System.out.println(ru.nextRandom());
        System.out.println(ru.nextRandom());
        System.out.println(ru.nextRandom());
        System.out.println(ru.nextRandom());
        System.out.println(ru.nextRandom());
        int[] range2 = new int[]{2, 13};
        // ru.updateRange(range2);
        // System.out.println(ru.nextRandom());
        // System.out.println(ru.nextRandom());
        // System.out.println(ru.nextRandom());
        // System.out.println(ru.nextRandom());
        // System.out.println(ru.nextRandom());
        // System.out.println(ru.nextRandom());
        // System.out.println(ru.nextRandom());
    } 
}
