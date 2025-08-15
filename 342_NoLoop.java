package Leetcode;
/*
Given an integer n, return true if it is a power of four. 
Otherwise, return false.

An integer n is a power of four, if there exists an
integer x such that n == 4x.
 */
class Solution342_BITWISE {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && n % 3 == 1;
    }
}
/*
 * EXPLANATION
 * -- n>0: only positive integers
 * -- (n & (n-1)): bitwise operation that finds if n is a power of 2
 * (2^n), Pattern: flips all the bits after a single 1 (if false, then
 * it is not a power of 2)
 * * we use 2^n because every power of 4 is a power of 2
 * BUT not every power of 2 is a power of 4, so:
 * -- n % 3 == 1: we use this to get remainder of 1, since all
 * powers of 4 will have a remainder of 1 if divided to 3
 */