package Leetcode;

import java.util.HashMap;
import java.util.Map;

//1394. Find Lucky Integer in an Array
/*
Given an array of integers arr, a lucky integer is an integer 
that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. 
If there is no lucky integer return -1.
 */
class Solution1394_Map {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int luckyInt = -1;

        for (int k : arr) {
            map.put(k, map.getOrDefault(k, 0) + 1); 
            /*
            map.getOrDefault() finds the key, if its not found,
            it will return default 0, if found, it will return its value.
            +1 is incrementing the value
            */
        }
        
        for(int key: map.keySet()) {
            if (map.get(key) == key) {
                luckyInt = key;
            }
        }
        return luckyInt;
    }
}