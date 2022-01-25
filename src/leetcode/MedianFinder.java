package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianFinder {
	List<Integer> numList = new ArrayList<>();
	
	public MedianFinder()
	{
	}	
	public void addNum(int num)
	{
		int len = numList.size();
		for(int i=0;i<=len;i++)
		{
			if(i==len)
			{
				numList.add(num);
				break;
			}
			if(numList.get(i)>=num)
			{
				numList.add(i, num);
				break;
			}
		}
	}
	public double findMedian()
	{
		int len = numList.size();
		return len%2==0?((numList.get(len/2)+numList.get(len/2-1))*1.0/2):(numList.get(len/2));
	}
}
