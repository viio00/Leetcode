/* 1984. Minimum Difference Between Highest and Lowest of K Scores
INTUITION:
1. sort the array
2. traverse the array -- since we base it by k, we use sliding window
    with a fix size of k. i is the leftmost boundary of the window.
    while the right boundary is i+k-1
3. the difference among k students is nums[i+k-1] - nums[i] (ascending)
*/
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i=0; i+k-1<len; i++) {
            ans = Math.min(ans, nums[i+k-1] - nums[i]);
        }

        return ans;
    }
}