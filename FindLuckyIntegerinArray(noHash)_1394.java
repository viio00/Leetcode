package Leetcode;
//1394. Find Lucky Integer in an Array
/*
Given an array of integers arr, a lucky integer is an integer 
that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. 
If there is no lucky integer return -1.
 */
class Solution1394_withoutUsingHash {
    public int findLucky(int[] arr) {
        int[] len = new int[501];

        for(int n : arr) {
            len[n] += 1;
        }
        //int[] len = {0,0,0,...,0 (500th)}
        //arr = {2,2,3,4}, so len = {0,0,2,1,4,0,..}
        /*meaning we have:
        index 2 -- we have 2 2s
        indes 3 -- we have 1 3s
        index 4 -- we have 1 4s
        */

        for (int i=len.length-1; i>=0; i--) { // start with the greatest value to easily return 
            if (i == len[i] && i!=0) {
                return i;
            }
        }
        
        return -1; 
    }
}