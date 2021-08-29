// [l, r] is the longest subarray contains one including l and r index
// r traverse the array, if r is 0, k--
// till k < 0, we cant filp anymore, we can do l++
// to make sure k is not over used, l needs to rule out the overused while k is smaller than 0
// and make sure if we rule out 0 we need to do k++
public class LongestConsecutiveOnes {
    public int LongestConsecutive(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= k) {
            return nums.length;
        }
        int left = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveOnes solution = new LongestConsecutiveOnes();
        int[] input = new int[]{1,0,0,0,1,1};
        System.out.println(solution.LongestConsecutive(input,2));
    }
}
