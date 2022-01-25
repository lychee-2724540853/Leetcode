package leetcode;

import java.util.Arrays;

/*
 * leetcode 528
 * 按权重随机选择
 */
public class Solution {
	int total = 0;
	int[] bound;
	public Solution(int[] w) {
		total = Arrays.stream(w).sum();
		bound = new int[w.length];
		bound[0] = w[0];
		for(int i=1;i<w.length;i++)
			bound[i] = bound[i-1] + w[i];
	}
	public int pickIndex()
	{
		int num = (int)(Math.random()*total) + 1;
		
		int left = 0;
		int right = bound.length-1;
		while(left<right)
		{
			int mid = (left-right)/2 + left;
			if(bound[mid]<num)
				left = mid + 1;
			else {
				right = mid;
			}
		}
		return left;
	}
}
