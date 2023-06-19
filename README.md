# DSA-Tries-StringSortingProblem
A solution for the given String sorting problem. Trie data structure was used. 

In this question, you will implement a String sorting algorithm. You will be given two same length of arrays of String. The Strings of the second array will not contain duplicate characters. You will sort the first array based on the following rules.
First, you need to find the distance between the Strings at the same index of the arrays. The distance calculation formula is:
-> Each letter has a number starting from 1 and increasing one by one. “A” is 1, while “Z” is 26.
-> The integer value of a String is determined by the letter number. For an example, the integer value of “abj” is 1210.
-> Find the distance between two Strings at the same indexes by subtracting their values. For example, the distance between at index “0” from the first array “abj” and from the second array “bal” is |1210-2112| = 902.
-> If the distance value is even, then sort your String from the first set based on the String from the second set. In our example “abj” will be sorted based on the order of “bal”, which ‘b’ has the highest priority while “l” has the least in sorting. The sorted version of “abj” will become “baj”. The order of letter “j” in the first string cannot be found in the second string. Therefore, you need to add it to the last of the String.
-> If the distance value is odd, then sort your string lexicographically in ascending order.
