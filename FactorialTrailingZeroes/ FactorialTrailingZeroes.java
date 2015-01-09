//========================================================================================================================
//
//Given an integer n, return the number of trailing zeroes in n!.
//
//Note: Your solution should be in logarithmic time complexity.
//
//
//========================================================================================================================


public class Solution {
	public int trailingZeroes(int n) {
		int count = 0;

		for (int i = 5; n / i > 0;) {
			count += n / i;
			n/=5;
		}
		return count;
	}
	

	
}
