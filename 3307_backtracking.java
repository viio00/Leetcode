package Leetcode;

class Solution3307_BT {
    /*
    Observations:
    1. if char is present in the 1st half, do not change or do anything special
    2. if char is present in 2nd half, change only if ops is 1 ('a' + count of ops  1)
    */ 
    public char kthCharacter(long k, int[] operations) {
        long len = 1; //not int, to avoid TLE use long since it can hold more values
        int itrtns = 0;
        while (len<k) {
            len *= 2;
            itrtns++;
        }
        int count = 0; //times ops 1 in array (a gets changed)
        while(k>1) {
            if (k>len/2 && operations[itrtns-1] == 1) {
                count++; 
            }
            if (k>len/2) k -= (1L<<(itrtns-1)); //like 2^(itrtns-1)
            itrtns--;
            len /= 2;
        }
        return (char) ('a' + (count%26));
    }

    
}