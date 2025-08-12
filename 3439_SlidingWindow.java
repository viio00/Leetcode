package Leetcode;
//3439. RESCHEDULE MEETINGS FOR MAXIMUM FREE TIME I

/*You are given an integer eventTime denoting the duration of 
an event, where the event occurs from time t = 0 to time t = eventTime.
You are also given two integer arrays startTime and endTime, 
each of length n. These represent the start and end time of n 
non-overlapping meetings, where the ith meeting occurs during the 
time [startTime[i], endTime[i]].

You can reschedule at most k meetings by moving their start time 
while maintaining the same duration, to maximize the longest continuous 
period of free time during the event.

The relative order of all the meetings should stay the same 
and they should remain non-overlapping.

Return the maximum amount of free time possible after rearranging the meetings.
Note that the meetings can not be rescheduled to a time outside the event. 
*/
class Solution3439_useSlidingWindow {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n+1];
        gaps[0] = startTime[0]; //index 0 (start)

        for (int i=1; i<n; i++) {
            // get gaps from index 1 - (n-1) (in-betweens)
            gaps[i] =  startTime[i] - endTime[i-1];
        }
        //index[n] gap (last)
        gaps[n] = eventTime - endTime[n - 1];

        int longestValidGap = 0;
        int sumOfGaps = 0;

        //Sliding window
        int j = 0;
        for (int i=0; i<=n; i++){
            sumOfGaps += gaps[i]; //adds all gaps

            if(i>k) { //maintrains gap number (k+1)
                sumOfGaps -= gaps[j];
                j++; 
                //this is to ensure that we rescheduled k times
            }
            longestValidGap = Math.max(longestValidGap, sumOfGaps);
        }
        return longestValidGap;
    }
}
/*
eventTime -- duration of the  event
startTime & endTime -- time of meetings
n -- length 
k -- how many meeting can be rescheduled in order to get the longest breaktime

note:
1. meetings are non-overlapping
2. rescheduled meeting hsould maintain their duratione w/o overlapping
3. order of meeting, even rescheduled, should stay the same

Solution:
1. Store gaps in between
-- make new array gaps[] with startTime.length +1 length
-- initialize index 0 to 0
-- get gaps: startTime[i] - endTime[i-1]
2. shift k meeting/s forward or backward
-- shift = reschedule = allows you to move k gap/s
-- or er can do both then return sumGap with Math.max()
*/