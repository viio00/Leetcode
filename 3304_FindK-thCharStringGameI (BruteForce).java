package Leetcode;
//3304.Find the K-th Character in String Game I
/*
 Alice and Bob are playing a game. Initially, 
 Alice has a string word = "a".
You are given a positive integer k.
Now Bob will ask Alice to perform the following operation forever:
Generate a new string by changing each character in word to 
its next character in the English alphabet, and append it 
to the original word.

For example, performing the operation on "c" generates "cd" 
and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, 
after enough operations have been done for word to have 
at least k characters.

Note that the character 'z' can be changed to 'a' in the operation.

-- Initial string = "a"
-- How string grows: a -> b (next char) = ab, ab -> bc = abbc, abbc -> bccd = abbcbccd
  - Keep origibal string
  - append shifted version (string doubling its size)
 */
//***** BRUTE FORCE APPROACH *****
class Solution3304_BF {
    static char kthCharacter(int k) {
        String word = "a";

        while (word.length() < k) {
            StringBuilder shift = new StringBuilder();
            //this should be inside while-loop to remove appended string

            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);

                char shiftChar = (char) ((c - 'a' + 1)%26 + 'a');
                /* A wrapper for shifting characters with the alphabet
                EXAMPLE: find next char for 'c'
                  ASCII for 'c' if 99, and 'a' (first/base) is 97. c = 'c'
                  so using the equation: 
                    - (('c (99)' - 'a (97)' + 1) = 3 
                      (+ 1: adds 1 to the index, shifting the character one position forward in the alphabet.)
                    - 3%26 = 3 (26 letters in the alphabet)
                    - 3 + 'a (97)') = 100
                    - 100 in ASCII is 'd' so c -> d

                Java reads charac´cters as numbers (ASCII/Unicode), so the arithmetic inside the
                code automatically converts the char to int. We use (char) in order ti return the in vaøue as char.
                */

                shift.append(shiftChar);
            }
            word += shift.toString();
        }

        return word.charAt(k-1);
    }

    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
    }
}