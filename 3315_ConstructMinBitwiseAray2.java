/* 3315. Construct the Minimum Bitwise Array II
You are given an array nums consisting of n prime integers.

You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].

Additionally, you must minimize each value of ans[i] in the resulting array.
-- this basically means, for example:
nums[i] = 15 (1111 in binary)
using ans[i] OR (ans[i] + 1):
- ans[i] = 14 (1110): 1110 OR 1111 (because we + 1 (14 + 1)) = 1111
- ans[i] = 13 (1101): 1101 OR 1110 = 1111 
- ans[i] = 11 (1011): 1011 OR 1100 = 1111 WE RETURN THIS since it is the LOWEST (min)

If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.
 */
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        
        for (int i=0; i<nums.size(); i++) {
            int a = nums.get(i); 

            if (a <= 2 || a %2 == 0) {
            //checks if a is less than 2 (constraints) amd if it is even no.
                ans[i] = -1;

            } else {
                ans[i] = a - ((a+1) & (-a-1)) / 2;
                /*
                -- (-a-1) is the inverse of a, denoted as ~a
                ex: a = 101 (5)
                a+1 = 110 (6)
                -a-1 = 010 (2)
                110 & 010 = 010/2 = 1
                then
                101 (a,5) - 1 (1) = 4 -- lowest value
                */
            }
        }
        return ans;
    }
}
