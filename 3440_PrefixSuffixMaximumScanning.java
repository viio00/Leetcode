package Leetcode;
//3440. RESCHEDULE MEETINGS FOR MAXIMUM FREE TIME II

/*
You are given an integer eventTime denoting the duration of an event. 
You are also given two integer arrays startTime and endTime, each of length n.

These represent the start and end times of n non-overlapping meetings 
that occur during the event between time t = 0 and time t = eventTime, 
where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most one meeting by moving its start time while
maintaining the same duration, such that the meetings remain non-overlapping,
to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.
Note that the meetings can not be rescheduled to a time outside the event and 
they should remain non-overlapping.

Note: In this version, it is valid for the relative ordering of the 
meetings to change after rescheduling one meeting.
 */
class Solution3340_PrefixSuffixMaxScan {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        //int durations = new int[n];
        int[] gaps = new int[n+1];
        gaps[0] = startTime[0]; 

        //durations[0] = endTime[0] - startTime[0];
        for (int i=1; i<n; i++) {
            gaps[i] =  startTime[i] - endTime[i-1];
            //durations[i] = endTime[i] - startTime[i];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int[] largestGapRight = new int[n+1];
        for (int i=n-1; i>=0; i--) {
            largestGapRight[i] = Math.max(largestGapRight[i+1], gaps[i+1]);
        }

        int maxFreeTime = 0, largestGapLeft = 0;
        for(int i=1; i<=n; i++) {
            int duration = endTime[i-1] - startTime[i-1];

            if(largestGapLeft >= duration || largestGapRight[i] >= duration) {
                int merge = gaps[i-1] + gaps [i] + duration;
                maxFreeTime = Math.max(maxFreeTime, merge);
            }

            maxFreeTime = Math.max(maxFreeTime, gaps[i-1] + gaps[i]);
            largestGapLeft = Math.max(largestGapLeft, gaps[i-1]);

        }
        return maxFreeTime;
    }
}

/* this only works for 204/695 cases >:(
        int longestValidGap = 0;
        int sumOfGaps = 0;
        int k = 1; //how many moves (at max k=2, this is to resched 1 meeting that fits a gap)
        int l, r = 0, j = 0, stop = 0;

        for (l=0; l<n && stop < 1; l++) {
            int smallest = 0;
            while (r < gaps.length && !(durations[l] <= gaps[r])) {
                r++;
                smallest = Math.min(smallest, gaps[l]);
            }
            if (r < gaps.length && durations[l] <= gaps[r]) {
                k++;
                stop++;
            } 
        
        }

        for (int i=0; i<=n; i++){
            sumOfGaps += gaps[i]; 
            if(i>k) {
                sumOfGaps -= gaps[j];
                j++; 
            }
            longestValidGap = Math.max(longestValidGap, sumOfGaps);
        }
        return longestValidGap;
    }
} */
