package nowcoder;

import java.util.Iterator;

public class test {
	/*
	 * NC78
	 * ·´×ªÁ´±í
	 */
	public static ListNode createListNode() {
		ListNode headListNode = new ListNode(1);
		headListNode.next = new ListNode(2);
		headListNode.next.next = new ListNode(3);
	
		return headListNode;
	}
	public static void showListNodeArr(ListNode head)
	{
		while(head!=null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static ListNode ReverseList(ListNode head)
	{
		ListNode last = null;
		ListNode next = null;
		while(head!=null)
		{
			next = head.next;
			head.next = last;
			last = head;
			head = next;
		}
		
		return last;
	}
	public static void showArr(int[] arr) {
		for(int i:arr)
			System.out.println(i);
		
	}
	public static void changePos(int []arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/*
	 * NC1400
	 * ÅÅÐò
	 */
	public static int[] Mysort(int[] arr)
	{
		int min = 0;
		int size = arr.length;
		int pos = 0;
		for(int i=0;i<size;i++)
		{
			min = arr[i];
			for(int j=i+1;j<size;j++)
			{
				if(arr[j]<min)
				{
					min = arr[j];
					pos = j;
				}
			}
			if(min<arr[i])
				changePos(arr, pos,i);
		}
		return arr;
	}
	public static int findmax(int[][] arr)
	{
		int n = arr.length;
		int m = arr[0].length;

		int[] row = new int[n];
		int[] col = new int[m];
		int max = 1;
		for(int i=0;i<n;i++)
			row[i] = 1;
		for(int i=0;i<m;i++)
			col[i] = 1;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				col[i] *= arr[j][i];
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				row[i] *= arr[i][j];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				int temp = (row[i] * col[j])/(arr[i][j]*arr[i][j]);
				if(temp>max)
					max = temp;
			}
		return max;
	}
	public static void main(String args[])
	{
		char x = 'A' + 1;
		
		System.out.println(x);
	}
}
