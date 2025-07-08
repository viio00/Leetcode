package Leetcode;

import java.util.Arrays;

// 1751. Maximum Number of Events That Can Be Attended II
/*
You are given an array of events where 
events[i] = [startDayi, endDayi, valuei]. The ith event 
starts at startDayi and ends at endDayi, 
and if you attend this event, you will receive a value of valuei. 
You are also given an integer k which represents
the maximum number of events you can attend.

You can only attend one event at a time. 
If you choose to attend an event, you must attend the entire event.
Note that the end day is inclusive: that is, 
you cannot attend two events where one of them starts and the 
other ends on the same day.

Return the maximum sum of values 
that you can receive by attending events.
 */
class Solution {
    int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));

        /*
        creating a memo table to store answers (subproblems)
        -- dp will store the max value 
        */
        dp = new int[events.length][k + 1];
        for (int i = 0; i < events.length; i++) {
            Arrays.fill(dp[i], -1); // -1 meand "not yet solved"
        }

        return dfs(events, 0, k);
    }

    private int dfs(int[][] events, int index, int k) {
        if (index == events.length || k == 0) return 0;
        if (dp[index][k] != -1) return dp[index][k];
         
        //skip
        int skip = dfs(events, index+1, k);
        //next
        int next = binarySearch(events, events[index][1]);
        //take
        int take = events[index][2] + dfs(events, next, k-1);

        return dp[index][k] = Math.max(skip, take);
    }

    private int binarySearch(int[][] events, int endDay) {
        int low = 0, high = events.length -1;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (events[mid][0] <= endDay){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return low; // points to first valid next event (non-overlapping)
    }
}
/*
1. Sort the array (via 0th index)
2. For each event, either: 
-- skip(i++, k) 
--take (dfs(nextIndex, k - 1))
-- both values will be recorded (memo), then retun the bigger value
3. Find the next non-overlapping event using Binary Search
-- events[mid][0] > events[i][1]
-- "mid" is the value returned by BS whose 0th value is greater than i array (previous array) index 1 (end date)
4. do no. 4 again 
*/