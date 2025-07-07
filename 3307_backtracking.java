package Leetcode;

//3307. Find the K-th Character in String Game II
/*
Alice and Bob are playing a game. Initially, 
Alice has a string word = "a".
You are given a positive integer k. You are also given 
an integer array operations, where operations[i] represents 
the type of the ith operation.

Now Bob will ask Alice to perform all operations in sequence:
If operations[i] == 0, append a copy of word to itself.
If operations[i] == 1, generate a new string by changing 
each character in word to its next character in the English alphabet,
 and append it to the original word. For example, 
 performing the operation on "c" generates "cd" and performing the 
 operation on "zb" generates "zbac".

Return the value of the kth character in word after performing 
all the operations.

Note that the character 'z' can be changed to 'a' in the second type of operation.
 */
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

//guide: https://www.youtube.com/watch?v=NEvFeGsunu4