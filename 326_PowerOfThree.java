package Leetcode;
/*
Given an integer n, return true if it is a power of three. 
Otherwise, return false.

An integer n is a power of three, 
if there exists an integer x such that n == 3x.
 */
class Solution326 {
    public boolean isPowerOfThree(int n) {
        // largest 32-bit int of 3^n is 3^19 = 1162261467
        return n > 0 && n % 2 == 1 && 1162261467 % n == 0;
    }
}