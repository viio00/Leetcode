package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
//1353. Maximum Number of Events That Can Be Attended
/*
You are given an array of events where events[i] = [startDayi, endDayi]. 
Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. 
You can only attend one event at any time d.

Return the maximum number of events you can attend.
 */
class Solution1353_withPQ {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        //It sorts a 2D array (like int[][] events) based on the first element of each row (a[0]).
        int len = events.length;
        int maxDay = 0;
        for (int[] end : events) {
            maxDay = Math.max(maxDay, end[1]);
        } 

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i=1, j=0; i<=maxDay; i++) {
            while (j < len && i >= events[j][0]) {
                pq.offer(events[j][1]); //queue the end day
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) { // remove expired events (endDay < i ex. enday(2)>curDay(3))
                pq.poll();

            }
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }
        return count;
    }
}
/*
START
1. sort the 2d array
2. get max day (Highest value of end day)

ALGO ***there are changes here***
1. Events will be iterated by j
2. Days will be iterated by i
3. see if current startDay is <= with Days(i)
-- then add current endDay to pq
4. iterate next (j) if curStart == pq, do no. 3
-- if not (curStart != prevEnd), pop pq, count++
DO THIS UNTIL EVENTS[][] && pq is both EMPTY, return count

* if we have 2 (or more) of the same values in pq
-- first one out will fill in its corresponding day (i == pq(val))
-- then pop remaining same value/s w/o count++
* if pq(val) >= Days (i), then fill in i and pop pq

PriorityQueue methods:

offer() → add to the queue
poll() → remove and return the smallest element
peek() → just look at the smallest, without removing

 */