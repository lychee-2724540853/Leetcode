package leetcode;

import java.awt.Label;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.print.Printable;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow.Publisher;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

import javax.naming.directory.SearchControls;
import javax.print.attribute.standard.Sides;
import javax.swing.JSpinner.DateEditor;
import javax.swing.tree.TreeNode;
import com.sun.jdi.ArrayReference;
import com.sun.jdi.Value;
import com.sun.net.httpserver.Authenticator.Result;
import com.sun.security.auth.NTDomainPrincipal;

public class demo {

	public List<List<String>> groupAnagrams(String[] strs)
	{
		List<List<String>> resultList = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		
		for(int i=0;i<strs.length;i++)
		{
			char[] s = strs[i].toCharArray();
			Arrays.sort(s);
			String arr = new String(s);
			if(!map.containsKey(arr))
			{
				List<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				map.put(arr, temp);
			}
			else {
				map.get(arr).add(strs[i]);
			}
		}
		
		for(String key:map.keySet())
		{
			resultList.add(map.get(key));
		}
		return resultList;
	}
	/*
	 * 剑指offer42----leetcode 53
	 * 连续子数组的最大和
	 */
	public int maxSubArray(int[] nums)
	{
		int max=nums[0];
		int pre = 0;
		for(int x:nums)
		{
			pre = Math.max(pre+x,x);
			max = Math.max(max, pre);
		}
		return max;
	}
	/*
	 * leetcode 20
	 * 有效的括号
	 */
	public boolean isValid(String s)
	{
		Map<Character, Character> chmap = new HashMap<>();
		chmap.put(')', '(');
		chmap.put('}', '{');
		chmap.put(']', '[');
		
		Stack<Character> chstack = new Stack<>();
		for(int i=0;i<s.length();i++)
		{
			if(chmap.containsValue(s.charAt(i)))
			{
				chstack.push(s.charAt(i));
			}
			else {
				if(chstack.isEmpty()||chstack.peek()!=chmap.get(s.charAt(i)))
					return false;
				else {
					chstack.pop();
				}
			}
		}
		return chstack.isEmpty();
	}
	/*
	 * leetcode 1838
	 * 最高频元素的频数
	 */
	public int maxFrequency(int[] nums,int k)
	{
		Arrays.sort(nums);
		int max = 1;
		int len = nums.length;
		int total = 0;
		int l = 0;
		for(int i=1;i<len;i++)
		{
			total += (nums[i] - nums[i-1])*(i-l);
			while(total>k)
			{
				total -= (nums[i]-nums[l]);
				l++;
			}
			max = Math.max(max, i-l+1);
		}
		return max;
	}
	/*
	 * leetcode 1877
	 * 数组中的最大数对和的最小值
	 */
	public int minPairSum(int[] nums)
	{
		Arrays.sort(nums);
		int max = nums[0];
		int len = nums.length;
		for(int i=0;i<len/2;i++)
		{
			max = Math.max(max, nums[i]+nums[len-i-1]);
		}
		
		return max;
	}
	/*
	 * leetcode 4
	 * 寻找两个正序数组的中位数
	 */
	public double findMeidianSortedArrays(int[] nums1, int[] nums2)
	{
		int len1 = nums1.length;
		int len2 = nums2.length;
		int i=0,j=0;
		int total = len1+len2;
		for(;i<len1&&j<len2&&total>2;)
		{
			if(nums1[i]<nums2[j])
				i++;
			else {
				j++;
			}
			if(nums1[len1-1]<nums2[len2-1])
				len2--;
			else {
				len1--;
			}
			total -= 2;
		}
		if(total==2)
			if(len1==1||len2==1)
				return (nums1[i]+nums2[j])*1.0/2;
			else
			{
				if(len1==0)
				return (nums2[j]+nums2[j+1])*1.0/2;
			else {
				return (nums1[i]+nums1[i+1])*1.0/2;
			}
			}
		else {
			if(i<len1)
				return nums1[i];
			else {
				return nums2[j];
			}
		}
	}
	/*
	 * 剑指offer 52 
	 * 两个链表的第一个公共节点
	 */
	static class ListNode
	{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int x) {
			this.val = x;
		}
		ListNode(int val, ListNode next)
		{
			this.val = val;
			this.next = next;
		}
	}
	public ListNode getIntersectVal(ListNode headA,ListNode headB)
	{
		if(headA==null||headB==null)
			return null;
		ListNode ha = headA;
		ListNode hb = headB;
		while(ha!=hb)
		{
			ha = ha==null?hb:ha.next;
			hb = hb==null?ha:hb.next;
		}
		
		return ha;
	}
	/*
	 * leetcode 509
	 * 斐波那契数列
	 */
	public int fib(int n)
	{
		int ans = 0;
		
		if(n<2)
			return n;
		int a = 0;
		int b = 1;
		
		while((n-1)>0)
		{
			ans = a+b;
			a = b;
			b = ans;
			n--;
		}
		return ans;
	}
	/*
	 * leetcode 1137
	 * 第N个泰波纳契数列
	 */
	public int tribonacci(int n)
	{
		if(n<=1)
			return n;
		if(n==2)
			return 1;
		int a = 0;
		int b = 1;
		int c = 1;
		int ans = 0;
		while(--n>1)
		{
			ans = a + b +c;
			a = b;
			b = c;
			c = ans;
		}
		return ans;
	}
	/*
	 * 剑指offer 09
	 * 用两个栈实现队列
	 */
	class CQueue
	{
		Stack<Integer> stk1;
		Stack<Integer> stk2;
		public CQueue()
		{
			stk1 = new Stack<Integer>();
			stk2 = new Stack<Integer>();
		}
		public void appendTail(int value)
		{
			stk1.push(value);
		}
		public int deleteHead()
		{
			int temp;
			while(stk1.size()>0)
			{
				stk2.push(stk1.pop());
			}
            if(stk2.size()>0)
                temp = stk2.pop();
            else
                temp = -1;
			while(stk2.size()>0)
			{
				stk1.push(stk2.pop());
			}
			return temp;
		}
	}
	/*
	 * leetcode 138
	 * 复制带随机指针的
	 */
	class Node
	{
		int val;
		Node next;
		Node random;
		
		public Node(int val)
		{
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	public Node copyRandomList(Node head)
	{
		HashMap<Node, Node> map = new HashMap();
		
		Node tempNode = head;
		
		while(tempNode!=null)
		{
			map.put(tempNode, new Node(tempNode.val));
			tempNode = tempNode.next;
		}
		tempNode = head;
		while(tempNode!=null)
		{
			map.get(tempNode).next = map.get(tempNode.next);
			map.get(tempNode).random = map.get(tempNode.random);
			tempNode = tempNode.next;
		}
		return map.get(head);
	}
	/*
	 * 面试题0.1 0.1
	 * 判定字符是否唯一
	 */
	public  boolean isUnique(String astr)
	{
		/*HashMap<Character, Integer> map = new HashMap<>();
		char[] str = astr.toCharArray();
		for(int i=0;i<astr.length();i++)
		{
			if(map.containsKey(str[i]))
				return false;
			map.put(str[i], 1);
		}
		return true;*/
		if(astr.length()==1)
			return true;
		char[] str = astr.toCharArray();
		Arrays.sort(str);
		for(int i=1;i<str.length;i++)
		{
			if(str[i]==str[i-1])
				return false;
		}
		return true;
	}
	/*
	 * leetcode 1893
	 * 检查是否区域内的所有整数都被覆盖
	 */
	public boolean isCovered(int[][] ranges, int left, int right)
	{
		int rows = ranges.length;
		for(int i=left;i<=right;i++)
		{
			int j=0;
			for(;j<rows;j++)
			{
				if(i<=ranges[j][1]&&i>=ranges[j][0])
					break;
			}
			if(j==rows)
				return false;
		}
		
		return true;
	}
	/*
	 * leetcode 70
	 * 爬楼梯
	 */
	public int climbStairs(int n)
	{
		int a = 0;
		int b = 1;
		int total = 0;
		
		for(int i=0;i<n;i++)
		{
			total = a + b;
			a = b;
			b = total;
		}
		
		return total;
	}
	/*
	 * leetcode 746
	 * 使用最小花费爬楼梯
	 */
	public int minCostClimbingStairs(int[] cost)
	{
		int mincost = 0;
		int a = 0;
		int b = 0;
		
		for(int i=2;i<=cost.length;i++)
		{
			mincost = Math.min(a+cost[i-2], b+cost[i-1]);
			a = b;
			b = mincost;
		}
		
		return mincost;
	}
	/*
	 * leetcode 198
	 * 打家劫舍
	 */
	public int rob(int[] nums)
	{
		if(nums.length==1)
			return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
		int cost = 0;
		int a = nums[0];
		int b = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++)
		{
			cost = Math.max(a+nums[i], b);
			a = b;
			b = cost;
		}
		return cost;
	}
	/*
	 * leetcode 213
	 * 打家劫舍2
	 */
	public int robChoice(int[] nums, int start,int end)
	{
		int first = nums[start];
		int second = Math.max(nums[start+1], first);
		int total = second;
		for(int i=start+2;i<=end;i++)
		{
			total = Math.max(second, first+nums[i]);
			first = second;
			second = total;
		}
		return total;
	}
	public int rob2(int nums[])
	{
		if(nums.length==1)
			return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        else {
			return Math.max(robChoice(nums, 0, nums.length-2), robChoice(nums, 1, nums.length-1));
		}
	}
	/*
	 * leetcode 1736
	 * 替换隐藏数字得到最晚时间
	 */
	public String maximumTime(String time)
	{
		char[] str = time.toCharArray();
		
		int len = str.length;
		for(int i=0;i<len;i++)
		{
			if(str[i]=='?')
				if(i==0)
					if(str[1]<='3'&&str[1]>='0'||str[1]=='?')
						str[i]='2';
					else
						str[i]='1';
				else if (i==1)
					if(str[0]=='2')
						str[i]='3';
					else {
						str[i]='9';
					}
				else if (i==3) {
					str[i]='5';
				}
				else {
					str[i]='9';
				}
		}
		return new String(str);
	}
	/*
	 * leetcode 740
	 * 删除并获得点数
	 */
	public int deleteAndEarn(int[] nums)
	{
		Arrays.sort(nums);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)
		{
			if(!map.containsKey(nums[i]))
				map.put(nums[i], nums[i]);
			else {
				map.put(nums[i], map.get(nums[i])+nums[i]);
			}
		}
		int[] temp = new int[nums[nums.length-1]];
		
		for(int i:map.keySet())
		{
			temp[i-1] = map.get(i);
		}
		return rob(temp);
	}
	/*
	 * leetcode 55
	 * 跳跃游戏
	 */
	public boolean canJump(int[] nums)
	{
		int max = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(i<=max)
			{
				max = Math.max(max, i+nums[i]);
				if(max>=nums.length-1)
					return true;
			}
		}
		return false;
	}
	/*
	 * leetcode 45
	 * 跳跃游戏 2
	 */
	public int jump(int[] nums)
	{
		int step = 0;
		int max = 0;
		int maxposition=0;
		for(int i=0;i<nums.length-1;i++)
		{
			max = Math.max(max, i+nums[i]);
			if(i==maxposition)
			{
				maxposition = max;
				step++;
			}
		}
		return step;
	}
	/*
	 * leetcode 1743
	 * 从相邻元素对还原数组
	 */
	public int[] restoreArray(int[][] adjacentPairs)
	{
		int[] nums = new int[adjacentPairs.length+1];
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i=0;i<adjacentPairs.length;i++)
		{
			map.putIfAbsent(adjacentPairs[i][0], new ArrayList<>());
			map.putIfAbsent(adjacentPairs[i][1], new ArrayList<>());
			map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
			map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
		}
		
		int start = 0;
		for(int i:map.keySet())
		{
			if(map.get(i).size()==1)
			{
				start =  i;
				break;
			}
		}
		nums[0] = start;
		nums[1] = map.get(start).get(0);
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		for(int i=2;i<nums.length;i++)
		{
			List<Integer> temp = map.get(nums[i-1]);
			nums[i] = nums[i-2]==temp.get(0)?temp.get(1):temp.get(0);
			System.out.println(nums[i]);
		}
		return nums;
	}
	/*
	 * leetcode 1713
	 * 得到子序列的最小操作次数
	 */
	public int BinarySearch(List<Integer> d, int target)
	{
		int len = d.size();
		if(len==0||target>d.get(len-1))
			return len;
		int low = 0;
		int high = len-1;
		while(low<high)
		{
			int mid = (high-low)/2+low;
			if(d.get(mid)<target)
				low = mid + 1;
			else
				high = mid;		
		}
		return low;
	}
	public int minOperations(int[] target, int[] arr)
	{
		int min = 0;
		List<Integer> newArrIntegers = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<target.length;i++)
		{
			map.put(target[i], i);
		}
		
		for(int val : arr)
		{
			if(map.containsKey(val))
			{
				int idx = map.get(val);
				int it = BinarySearch(newArrIntegers, idx);
				if(it!=newArrIntegers.size())
					newArrIntegers.set(it, idx);
				else {
					newArrIntegers.add(idx);
				}
			}
		}
		
		return target.length-newArrIntegers.size();
	}
	/*
	 * leetcode 863
	 * 二叉树中所有距离为K的结点
	 */
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int x){val = x;}
		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	Map<Integer,TreeNode> parents = new HashMap<>();
	List<Integer> ans = new ArrayList<>();
	public void findParents(TreeNode node)
	{
		if(node.left!=null)
		{
			parents.put(node.left.val, node);
			findParents(node.left);
		}
		if(node.right!=null)
		{
			parents.put(node.right.val, node);
			findParents(node.right);
		}
	}
	public void findAns(TreeNode node,TreeNode from,int depth,int k)
	{
		if(node==null)
			return;
		if(depth==k)
		{
			ans.add(node.val);
			return;
		}
		if(node.left!=from)
			findAns(node.left, node, depth+1, k);
		if(node.right!=from)
			findAns(node.right, node, depth+1, k);
		if(parents.get(node.val)!=from)
			findAns(parents.get(node.val), node, depth+1, k);
	}
	public List<Integer> distanceK(TreeNode root,TreeNode target, int K)
	{
		findParents(root);
		findAns(target, null, 0, K);
		return ans;
	}
	/*
	 * leetcode 1104
	 * 二叉树寻路
	 */
	public List<Integer> pathInZigZagTree(int label)
	{
		int row = 1;
		int temp = label;
		while(temp!=1)
		{
			row++;
			temp = temp/2;
		}
		int start = 0;
		int end = 0;
		List<Integer> result = new ArrayList<Integer>();
		result.add(0,label);
		while(label!=1)
		{
			start = (int) Math.pow(2, row-1);
			end = (int) (Math.pow(2, row)-1);
			row--;
			label = start + end - label;
			label = label/2;
			result.add(0,label);
			System.out.println(result.get(0));
		}
		return result;
	}
	/*
	 * leetcode 171
	 * Excel表列序号
	 */
	public int titleToNumber(String columnTitle)
	{
		int result = 0;
		int len = columnTitle.length();
		for(int i=0;i<len;i++)
		{
			result += (columnTitle.charAt(i)-'A'+1)*Math.pow(26, len-i-1);
		}
		
		return result;
	}
	/*
	 * leetcode 987
	 * 二叉树的垂序遍历
	 */
	public void dfs(TreeNode node, int row, int col, List<int[]> nodes)
	{
		if(node == null)
			return;
		nodes.add(new int[] {col,row,node.val});
		dfs(node.left, row+1, col-1, nodes);
		dfs(node.right, row+1, col+1, nodes);
	}
	public List<List<Integer>> verticalTraversal(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();
		List<int[]> node = new ArrayList<>();
		dfs(root,0,0,node);
		
		Collections.sort(node, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else if (o1[1]!=o2[1])
					return o1[1]-o2[1];
				else
					return o1[2]-o2[2];
			}
		});
		int size = 0;
		int lastcol = Integer.MIN_VALUE;
		for(int[] tuple :node)
		{
			int col = tuple[0], row = tuple[1], Value = tuple[2];
			if(col!=lastcol)
			{
				lastcol = col;
				result.add(new ArrayList<>());
				size++;
			}
			result.get(size-1).add(Value);
		}
		return result;
	}
	/*
	 * leetcode 1337
	 * 矩阵中战斗力最弱的K行
	 */
	public int sumRow(int[] row)
	{
		int sum = 0;
		int j=0;
		int len = row.length;
		while(j<len&&row[j]!=0)
		{
			sum++;
			j++;
		}
		return sum;
	}
	public int[] kWeakesRows(int[][] mat,int k)
	{
		int[] result = new int[k];
		List<int[]> matList = new ArrayList<>();
		int rows = mat.length;
		if(k>=rows)
			return new int[] {};
		for(int i=0;i<rows;i++)
		{
			int temp = sumRow(mat[i]);
			matList.add(new int[] {temp,i});
		}
		Collections.sort(matList,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else
					return o1[1]-o2[1];
			}
		});
		for(int i=0;i<k;i++)
		{
			result[i] = matList.get(i)[1];
			System.out.println(result[i]);
		}
		return result;
	}
	/*
	 * leetcode 743
	 * 网络延迟时间   
	 * 未解决
	 */
	HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
	int result = 0;
	public boolean judgeCount(int[] arr)
	{
		for(int i:arr)
			if(i==0)
				return false;
		return true;
	}
	public int[] search(int k,int[] count,List<Integer> mo)
	{
		while(!judgeCount(count))
		{
			if(!map.containsKey(k))
			{
				System.out.println("...");
				return count;
			}
			for(int i=0;map.get(k).size()>0;)
			{
				List<Integer> temp = map.get(k).get(i);
				System.out.println(result);
				System.out.println(temp);
				count[temp.get(0)-1] = 1;
				result += temp.get(1);
				map.get(k).remove(temp);
				count = search(temp.get(0), count,temp);
			}
			if(map.get(k).size()==0)
				return count;
		}
		return count;
	}
	public int networkDelayTime(int[][] times,int n,int k)
	{
		int rows = times.length;
		int[] count = new int[n];
		count[k-1] = 1;
		for(int i=0;i<rows;i++)
		{
			map.putIfAbsent(times[i][0], new ArrayList<>());
			map.get(times[i][0]).add(new ArrayList<>());
			map.get(times[i][0]).get(map.get(times[i][0]).size()-1).add(times[i][1]);
			map.get(times[i][0]).get(map.get(times[i][0]).size()-1).add(times[i][2]);
		}
		for (Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		if(!map.containsKey(k))
		{
			return -1;
		}
		count = search(k, count,null);
		
		if(!judgeCount(count))
			return -1;

		return result;
	}
	/*
	 * leetcode 581
	 * 最短无序连续子数组
	 */
	public int findUnsortedSubarray(int[] nums)
	{
		if(nums.length==1)
			return 0;
		int[] copyNums = new int[nums.length];

		copyNums = Arrays.copyOfRange(nums, 0, nums.length);
		Arrays.sort(copyNums);

		int left = 0;
		int len = nums.length;
		int right = nums.length-1;
		
		for(int i:copyNums)
			System.out.println(i);
		boolean rightFlag = true;
		boolean leftFlag = true;
		for(int i=0;right>left&&i<len;i++)
		{
			if(nums[i]==copyNums[i]&&leftFlag)
			{
				left = i+1;
			}
			else {
				leftFlag = false;
			}
			if(nums[len-i-1]==copyNums[len-i-1]&&rightFlag)
			{
				right = len-i-1-1;
			}
			else {
				rightFlag = false;
			}
		}
		System.out.println(left);
		System.out.println(right);
		return right==left?0:right-left+1;
		
	}
	/*
	 * leetcode 611
	 * 有效三角形的个数
	 */
	public int triangleNumber(int[] nums)
	{
		int result=0;
		
		Arrays.sort(nums);
		int len = nums.length;
		for(int i=0;i<len-2;i++)
		{
			for(int j=i+1;j<len-1;j++)
			{
				int temp = nums[i]+nums[j];
				int left = j+1, right = len-1,k=j;
				while(left<=right)
				{
					int mid = (left+right)/2;
					if(nums[mid]<temp)
					{
						k = mid;
						left = mid + 1;
					}
					else {
						right = mid - 1;
					}
				}
				result += k-j;
			}
		}
		return result;
	}
	/*
	 * leetcode 457
	 * 环形数组是否存在循环
	 */
	public int next(int [] nums, int cur)
	{
		int n = nums.length;
		return ((cur+nums[cur])%n+n)%n;
	}
	public boolean circularArrayLoop(int[] nums)
	{
		int len = nums.length;
		
		for(int i=0;i<len;i++)
		{
			if(nums[i]==0)
				continue;
			int slow = i, fast = next(nums, i);
			while(nums[slow]*nums[fast] > 0&& nums[slow]*nums[next(nums, fast)]>0)
			{
				if(slow==fast)
				{
					if(slow!=next(nums, slow))
					{
						return true;
					}
					else {
						break;
					}
				}
				slow = next(nums, slow);
				fast = next(nums, next(nums, fast));
			}
			int add = i;
			while(nums[add]*nums[next(nums, add)]>0)
			{
				int tmp = add;
				add = next(nums, add);
				nums[tmp] = 0;
			}
		}
		return false;
	}
	/*
	 * leetcode 918
	 * 环形子数组的最大和
	 */
	public int kadane(int[] arr, int i, int j,int sign)
	{
		int cur = Integer.MIN_VALUE/2;
		int max= Integer.MIN_VALUE/2;
		for(int x=i;x<=j;x++)
		{
			cur = sign * arr[x] + Math.max(cur, 0);
			max = Math.max(cur, max);
		}
		return max;
	}
	public int maxSubarraySumCircular(int[] nums)
	{
		int Sum = 0;
		for(int x:nums)
			Sum += x;
		
		int max1 = kadane(nums, 0, nums.length-1, 1);
		int max2 = Sum + kadane(nums, 1, nums.length-2, -1);
		
		return Math.max(max1, max2);
	}
	/*
	 * leetcode 263
	 * 丑数
	 */
	public boolean isUgly(int n)
	{
		if(n<=0)
			return false;
		int[] factors = {2,3,5};
		for(int factor:factors)
		{
			while(n%factor==0)
				n /= factor;
		}
		return n==1;
	}
	/*
	 * leetcode 264
	 * 丑数 Ⅱ
	 */
	public int nthUglyNumber(int n)
	{
		List<Integer> numList = new ArrayList<>();
		
		numList.add(1);
		int[] factors = {2,3,5};
		int p2=0;
		int p3=0;
		int p5=0;
		
		for(int i=1;i<n;i++)
		{
			int num1 = numList.get(p2)*2;
			int num2 = numList.get(p3)*3;
			int num3 = numList.get(p5)*5;
			int temp = Math.min(num1, Math.min(num2, num3));
			if(temp==num1)
				p2++;
			if(temp==num2)
				p3++;
			if(temp==num3)
				p5++;
			
			numList.add(temp);
		}
		
		return numList.get(n-1);
	}
	//最小堆实现
	public int  nthUglyNumber1(int n)
	{
		Set<Integer> numSet = new HashSet<>();
		PriorityQueue<Integer> numQueue = new PriorityQueue<>();
		int result = 0;
		int[] factors = {2,3,5};
		numSet.add(1);
		numQueue.offer(1);
		for(int i=0;i<n;i++)
		{
			result = numQueue.poll();
			for(int factor:factors)
			{
				int temp = result*factor;
				if(numSet.add(temp))
					numQueue.offer(temp);
			}
		}
		return result;
	}
	/*
	 * leetcode 313
	 * 超级丑数
	 */
	//最小堆
	public int nthSuperUglyNumber(int n, int[] primes)
	{
		Set<Long> numSet = new HashSet<>();
		PriorityQueue<Long> numQueue = new PriorityQueue<>();
		numSet.add(1L);
		numQueue.offer(1L);
		
		int result=0;
		for(int i=0;i<n;i++)
		{
			long num = numQueue.poll();
			result = (int)num;
			for(int factor:primes)
			{
				long temp = result*factor;
				if(numSet.add(temp))
					numQueue.offer(temp);
			}
		}
		return result;
	}
	//
	public int nthSuperUglyNumber1(int n, int[] primes)
	{
		int len = primes.length;
		int[] p = new int[len];
		List<Integer> numList = new ArrayList<>();
		Arrays.fill(p, 0);
		numList.add(1);
		for(int i=1;i<n;i++)
		{
			int[] temp = new int[len];
			int minNum = Integer.MAX_VALUE;
			for(int k=0;k<len;k++)
			{
				temp[k] = primes[k]*numList.get(p[k]);
				minNum = Math.min(minNum, temp[k]);
			}
			for(int k=0;k<len;k++)
			{
				if(minNum==temp[k])
					p[k]++;
			}
			numList.add(minNum);
		}
		return numList.get(n-1);
	}
	/*
	 * leetcode 413
	 * 等差数列划分
	 */
	public int numberOfArithmeticSlice(int[] nums)
	{
		if(nums.length<=2)
			return 0;
		int len = nums.length;
		int result = 0;
		int temp = 1;
		int sub = nums[1]-nums[0];
		for(int i=2;i<len;i++)
		{
			if(nums[i]-nums[i-1]==sub)
			{
				result += temp;
				temp++;
			}
			else {
				sub = nums[i]-nums[i-1];
				temp = 1;
			}
		}
		return result;
	}
	/*
	 * leetcode 446
	 * 等差数列划分 Ⅱ - 子序列
	 */
	public int numberOfArithmeticSlices(int[] nums)
	{
		int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
	}
	/*
	 * leetcode 516
	 * 最长回文子序列
	 */
	public int longestPalindromeSubseq(String s)
	{
		int len = s.length();
		int[][] count = new int[len][len];
		
		for(int i=len-1;i>=0;i--)
		{
			count[i][i] = 1;
			char start = s.charAt(i);
			for(int j=i+1;j<len;j++)
			{
				char end = s.charAt(j);
				if(start==end)
				{
					count[i][j] = count[i+1][j-1] + 2;
				}
				else {
					count[i][j] = Math.max(count[i][j-1], count[i+1][j]);
				}
			}
		}
		return count[0][len-1];
	}
	/*
	 * leetcode 233
	 * 数字 1 的个数
	 */
	public int countDigitOne(int n)
	{
		long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
	}
	/*
	 * leetcode 551
	 * 学生出勤记录 Ⅰ
	 */
	public boolean checkRecord(String s)
	{
		int ACount=0;
		char last2 = ' ';
		char last = ' ';
		int len = s.length();
		
		for(int i=0;i<len;i++)
		{
			if(s.charAt(i)=='A')
				ACount++;
			if(ACount==2)
				return false;
			if(s.charAt(i)=='L'&&last=='L'&&last2=='L')
				return false;
			last2 = last;
			last = s.charAt(i);
		}
		return true;
	}
	/*
	 * lettcode 552
	 * 学生出勤记录 Ⅱ
	 */
	public int checkRecord(int n)
	{
		final int MOD = 1000000007;
		int[][] record = new int[2][3];
		record[0][0] = 1;
		
		for(int i=0;i<n;i++)
		{
			int[][] temp = new int[2][3];
			for(int j=0;j<2;j++)
			{
				for(int k=0;k<3;k++)
				{
					temp[j][0] = (temp[j][0] + record[j][k])%MOD;
				}
			}
			for(int k=0;k<3;k++)
			{
				temp[1][0] = (temp[1][0] + record[0][k])%MOD;
			}
			for(int j=0;j<2;j++)
			{
				for(int k=1;k<3;k++)
				{
					temp[j][k] = (temp[j][k] + record[j][k-1])%MOD;
				}
			}
			record = temp;
		}
		int sum = 0;
		for(int j=0;j<2;j++)
			for(int k=0;k<3;k++)
				sum = (sum+record[j][k])%MOD;
		return sum;
	}
	/*
	 * leetcode 345
	 * 反转字符串中的元音字母
	 */
	public String reverseVowels(String s)
	{
		int left = 0;
		int right = s.length()-1;
		char[] arr = s.toCharArray();
		List<Character> vowels = new ArrayList();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		while(left<right)
		{
			
			while(left<right&&!vowels.contains(arr[left]))
			{
				left++;
			}
			while(left<right&&!vowels.contains(arr[right]))
				right--;
			char temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			right--;
			left++;
		}
		return new String(arr);
	}
	/*
	 * leetcode 541
	 * 反转字符串 Ⅱ
	 */
	public String reverseStr(String s, int k)
	{
		int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
	}
	public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
	/*
	 * leetcode 443
	 * 压缩字符串
	 */
	public int compress(char[] chars)
	{
		List<Character> arr = new ArrayList<Character>();
		
		int count = 0;
		
		int len = chars.length;
		int temp = 1;
		count++;
		arr.add(chars[0]);
		for(int i=1;i<len;i++)
		{
			if(chars[i]==chars[i-1])
				temp++;
			else {
				String p = Integer.toString(temp);
				if(temp==1)
					count++;
				else
				{
					count += p.length()+1;
					for(int j=0;j<p.length();j++)
						arr.add(p.charAt(j));
				}
				temp = 1;
				arr.add(chars[i]);
			}
		}
		String p = Integer.toString(temp);
		if(temp!=1)
		{
			for(int j=0;j<p.length();j++)
				arr.add(p.charAt(j));
			count += p.length();
		}
		for(int i=0;i<arr.size();i++)
			chars[i] = arr.get(i);
		System.arraycopy(chars, 0, chars, 0, arr.size());
		for(char c:chars)
		System.out.println(c);
		return count;
	}
	public int compress1(char[] chars)
	{
		int count = 0;
		
		int len = chars.length;
		int temp = 1;
		count++;
		int pos = 1;
		for(int i=1;i<len;i++)
		{
			if(chars[i]==chars[i-1])
				temp++;
			else {
				String p = Integer.toString(temp);
				if(temp==1)
					count++;
				else
				{
					count += p.length()+1;
					for(int j=0;j<p.length();j++)
					{
						chars[pos] = p.charAt(j);
						pos++;
					}
				}
				temp = 1;
				chars[pos] = chars[i];
				pos++;
			}
		}
		String p = Integer.toString(temp);
		if(temp!=1)
		{
			for(int j=0;j<p.length();j++)
			{
				chars[pos] = p.charAt(j);
				pos++;
			}
			count += p.length();
		}
		for(char c:chars)
		System.out.println(c);
		return count;
	}
	/*
	 * leetcode 789
	 * 逃脱阻碍着
	 */
	public boolean escapGhosts(int[][] ghosts, int[] target)
	{
		int dis = Math.abs(target[0]) + Math.abs(target[1]);
		int len = ghosts.length;
		int[] dists = new int[len];
		
		for(int i=0;i<len;i++)
		{
			int dist = Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]);
			if(dist<=dis)
				return false;
		}
		return true;
	}
	/*
	 * leetcode 1646 
	 * 获取生成数组中的最大值
	 */
	public int getMaximumGenerated(int n)
	{
		if(n==0)
            return 0;
        int[] nums = new int[n+1];
		nums[0] = 0;
		nums[1] = 1;
        int temp = 1;
		for(int i=2;i<=n;i++)
        {
			nums[i] = nums[i/2] + i%2*nums[i/2+1];
            temp = Math.max(temp,nums[i]);
        }
		return temp;
	}
	/*
	 * leetcode 881
	 * 救生艇
	 */
	public int numRescueBoats(int[] people, int limit)
	{
		Arrays.sort(people);
		for(int i:people)
		System.out.println(i);
		
		int left = 0;
		int right = people.length-1;
		int result = 0;
		while(left<=right)
		{
			int temp = people[right] + people[left];
			if(temp<=limit)
				left++;
			result++;
			right--;
		}
		return result;
	}
	/*
	 * leetcode 1480
	 * 一维数组的动态和
	 */
	public int[] runningSum(int[] nums)
	{
		int len = nums.length;
		for(int i=1;i<len;i++)
		{
			nums[i] += nums[i-1];
		}
		for(int i:nums)
			System.out.println(i);
		return nums;
	}
	/*
	 * leeetcode 1588
	 * 所有奇数长度子数组的和
	 */
	public int sumOddLengthSubarrays(int[] arr)
	{
		int len = arr.length;
		int sum = 0;
		for(int i=0;i<len;i++)
		{
			int temp = arr[i];
			sum += temp;
			for(int j=i+2;j<len;j+=2)
			{
				temp = temp + arr[j] + arr[j-1];
				sum += temp;
			}
		}
		return sum;
	}
	/*
	 * leetcode 1109
	 * 航班预定统计
	 */
	public int[] corpFlightBookings(int[][] bookings, int n)
	{
		int[] result = new int[n];
		int len = bookings.length;
		for(int i=0;i<len;i++)
		{
			for(int j=bookings[i][0]-1;j<bookings[i][1];j++)
			{
				result[j] += bookings[i][2];
			}
		}
		
		for(int i:result)
			System.out.println(i);
		return result;
	}
	/*
	 * leetcode 165
	 * 比较版本号
	 */
	public int compareVersion(String version1, String version2)
	{
		int len1 = version1.length();
		int len2 = version2.length();
		
		int i=0,j=0;
		while(i<len1||j<len2)
		{
			int x=0;
			for(;i<len1&&version1.charAt(i)!='.';i++)
			{
				x = x*10 + version1.charAt(i)-'0';
			}
			++i;
			int y=0;
			for(;j<len2&&version2.charAt(j)!='.';j++)
			{
				y = y*10 + version2.charAt(j)-'0';
			}
			++j;
			if(x!=y)
				return x>y?1:-1;
		}
		return 0;
	}
	/*
	 * 剑指 offer 22
	 * 链表中倒数第k个节点
	 */
	public ListNode getKthFromEnd(ListNode head, int k)
	{
		int n = 0;
        ListNode node = null;

        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }

        return node;
	}
	/*
	 * 面试题17.14
	 * 最小K个数
	 */
	public int[] smallestK(int[] arr, int k)
	{
		int[] result = new int[k];
		
		Arrays.sort(arr);
		
		for(int i=0;i<k;i++)
			result[i] = arr[i];
		return result;
	}
	/*
	 * Leetcode 206 
	 * 反转列表
	 */
	public ListNode reverseList(ListNode head)
	{
		ListNode pre = null;
		ListNode temp = head;
		
		while(temp!=null)
		{
			ListNode next = temp.next;
			temp.next = pre;
			pre = temp;
			temp = next;
		}

		return pre;
	}
	/*
	 * Leecode 3
	 * 无重复字符的最长字串
	 */
	public int lengthOfLongestSubstring(String s)
	{
		int len = s.length();
		int result = 0;
		
		int left = 0, right = 0;
		
		while(right<len)
		{
			char c = s.charAt(right);
			String temp = s.substring(left, right);
			if(temp.indexOf(c)==-1)
            {
                right++;
                int length = right - left;
				if(length>result)
					result = length;
            }
			else
				left++;
		}
		return result;
	}
	/*
	 * leetcode 215
	 * 数组中的第K个最大的元素
	 */
	public int findKthLargest(int[] nums, int k)
	{
		/*
		 * 调库方法
		Arrays.sort(nums);
		return nums[nums.length-k];
		*/
		fastSort(nums, 0, nums.length-1);
		return nums[nums.length-k];
	}
	/*
	 * 快速排序
	 */
	public void fastSort(int [] nums, int left, int right)
	{
		int pos = left;
		if(left<=right)
		{
			pos = patition(nums, left, right);
			fastSort(nums, left,pos-1);
			fastSort(nums, pos+1, right);
		}
	}
	public int patition(int [] nums, int left, int right)
	{
		int temp = nums[left];
		
		while(left<right)
		{
			while(left<right && nums[right]>temp) --right;
			nums[left] = nums[right];
			while(left<right && nums[left]<=temp) ++left;
			nums[right] = nums[left];
		}
		nums[left] = temp;
		return left;
	}
	public void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	/*
	 * leetcode 103
	 * 二叉树的锯齿形层序遍历
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> resultList = new ArrayList<>();
		List<TreeNode> nodeList = new ArrayList<>();
		List<Integer> posList = new ArrayList<>();
		if(root!=null)
        {
            posList.add(0);
            nodeList.add(root);
        }
		
		int i=0;
		while(i<nodeList.size())
		{
			TreeNode temp = nodeList.get(i);
			int pos = posList.get(i) + 1;
			if(resultList.size()<pos)
			{
				List<Integer> newList = new ArrayList<>();
				resultList.add(newList);
			}
			resultList.get(pos-1).add(temp.val);
			if(temp.left!=null)
			{
				nodeList.add(temp.left);
				posList.add(pos);
			}
			if(temp.right!=null)
			{
				nodeList.add(temp.right);
				posList.add(pos);
			}
			i++;
		}
		for(int j=0;j<resultList.size();j++)
		{
			if(j%2!=0)
				Collections.reverse(resultList.get(j));
		}
		return resultList;
	}
	/*
	 * leetcode 15
	 * 三数之和
	 */
	public List<List<Integer>> threeSum(int[] nums)
	{
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		for(int start=0; start<len; start++)
		{
			if(start>0&&nums[start]==nums[start-1])
				continue;
			int a = -nums[start];
			int j = len-1;
			for(int i=start+1;i<len;i++)
			{
				if(i>(start+1)&&nums[i]==nums[i-1])
					continue;
				while(nums[i]+nums[j]>a && i < j)
					j--;
				if(j==i)
					break;
				if((nums[i] + nums[j]) == a)
				{
					List<Integer> temp = new ArrayList<>();
					temp.add(-a);
					temp.add(nums[i]);
					temp.add(nums[j]);
					result.add(temp); 
				}
			}
			start++;
		}
		return result;
	}
	/*
	 * leetcode 4
	 * 寻找两个正序数组的中位数
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
		int len1 = nums1.length;
		int len2 = nums2.length;
		int total_len = len1 + len2;
		int steps = (int) (total_len%2==0?(total_len/2+1):Math.ceil(total_len/2+1));
		int point1 = 0, point2 = 0;
		int counted = 0;
		int a=0,b=0;
		while(counted<steps)
		{
			b = a;
			if(point1>=len1)
				a = nums2[point2++];
			else if(point2>=len2)
				a = nums1[point1++];
			else if(nums1[point1]<=nums2[point2])
				a = nums1[point1++];
			else
				a = nums2[point2++];
			counted++;
		}
		if(total_len%2==0)	
			return (a+b)/2.0;
		else {
			return (double)a;
		}
	}
	/*
	 * leetcode 217
	 * 存在重复元素
	 */
	public boolean containsDuplicate(int[] nums)
	{
		/*
		 * hashset保证set集合中的元素不重复，只保留hashmap的key
		 * 即二者的区别时set只是单一数据的集合，而hashmap存储的是键值对
		 */
		Set<Integer> set = new HashSet<>();
		for(int i:nums)
		{
			if(!set.add(i))
				return true;
			
		}
		return false;
		/*
		Map<Integer, Boolean> map = new HashMap<>();
		for(int i:nums)
		{
			if(map.containsKey(i))
				return true;
			map.put(i, true);
		}
		return false;
		*/
	}
	
	/*
	 * leetcode 121 
	 * 买卖股票的最佳时机
	 */
	public int maxProfit(int[] prices)
	{
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0;i<prices.length;i++)
		{
			if(prices[i]<min)
				min = prices[i];
			else if(prices[i]-min>profit)
				profit = prices[i] - min;
		}
		return profit;
	}
	/*
	 * leetcode 1
	 * 两数之和
	 */
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)
		{
			if(map.containsKey(target-nums[i]))
			{
				return new int[] {map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}
	/*
	 * leetcode 236
	 * 二叉树的最近公共祖先
	 */
	private TreeNode ancetor = null;
	private boolean dfs(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root==null)
			return false;
		boolean lson = dfs(root.left, p, q);
		boolean rson = dfs(root.right, p, q);
		if((lson&&rson)||(root.val==p.val)||(root.val==q.val)&&(lson||rson))
			ancetor = root;
		return lson || rson ||( root.val==p.val || root.val==q.val);
	}
	public TreeNode lowestCommomAcestor(TreeNode root, TreeNode p, TreeNode q)
	{
		dfs(root, p, q);
		return ancetor;
	}
	/*
	 * leetcode 119
	 * 杨辉三角 Ⅱ
	 */
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		
		for(int i=1;i<=rowIndex;i++)
		{
			int temp = result.get(0);
			int val = temp;
			for(int j=1;j<i;j++)
			{
				temp = result.get(j);
				result.set(j, val+result.get(j));
				val = temp;
			}
			result.add(1);
		}

		return result;
	}
	/*
	 * leetcode 1143
	 * 最长公共子序列
	 */
	public int longestCommonSubsequence(String text1, String text2)
	{
		int len1 = text1.length();
		int len2 = text2.length();

		int[][] table = new int[len1+1][len2+1];

		int x=0,y=0;
		for(int i=1; i<=len1; i++)
		{
			for(int j=1;j<=len2; j++)
			{
				if(text1.charAt(i-1)==text2.charAt(j-1))
				{
					if(i-1>x&&j-1>y)
					{
						x = i-1;
						y = j-1;
					}
					table[i][j] = table[i-1][j-1] + 1;
				}
				else if(table[i-1][j]>=table[i][j-1])
					table[i][j] = table[i-1][j];
				else
					table[i][j] = table[i][j-1];
			}
		}
		for(int i=0;i<=len1;i++)
		{
			for(int j=0;j<=len2;j++) {
				System.out.print(table[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println(x);
		System.out.println(y);
		return table[len1][len2];

	}
	/*
	leetcode 11
	盛最多水的容器
	 */
	public int maxArea(int[] height)
	{
		int l = 0;
		int r = height.length-1;
		int result = 0;

		while(l<r)
		{
			int temp = Math.min(height[l],height[r])*(r-l);
			if(temp>result)
			{
				result = temp;
			}
			if(height[l]<=height[r])
				l++;
			else
				r--;
		}
		return result;
	}
	public static String convevrtToTitle(int columnNumber)
	{
		StringBuffer result = new StringBuffer();
		
		while(columnNumber>0)
		{
			int last = (columnNumber-1)%26;
			result.append((char)('A'+last));
			columnNumber = (columnNumber-1)/26;
		}
		return result.reverse().toString();
	}
	/*
	 * Leetcode 25
	 * K个一组翻转链表
	 */
	public static ListNode getListNode()
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		return head;
	}
	public static void showListNode(ListNode head) {
		while(head!=null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static ListNode reverseListNode(ListNode head, int k)
	{
		ListNode pre = null;
		ListNode next = null;
		
		while(head!=null&&k>0)
		{
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
			k--;
		}
		return pre;
	}
	public static ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode pre = null;
		ListNode help = new ListNode(0);
		help.next = head;
		pre = help;
		while(head!=null)
		{
			int count = 0;
			ListNode countListNode = head;
			while(countListNode!=null&&count<k)
			{
				countListNode = countListNode.next;
				count++;
			}
			if(count<k)
				break;
			pre.next = reverseListNode(head, k);
			head.next = countListNode;
			pre = head;
			head = head.next;
		}
		return help.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = getListNode();
		showListNode(head);
		head = reverseKGroup(head, 2);
		showListNode(head);
	}
	/*
	 * leetcode 415
	 * 字符串相加
	 */
	public String addStrings(String num1, String num2) {
        StringBuffer result = new StringBuffer();
		int i =num1.length() - 1;
		int j = num2.length() - 1;
		int flag = 0;
		
		while(i>=0 || j>=0 || flag!=0)
		{
			int x = i>=0?num1.charAt(i--) - '0': 0;
			int y = j>=0?num2.charAt(j--) - '0': 0;
			
			int z = x + y + flag;
			result.append(z%10);
			
			flag = z/10;
		}
		result.reverse();
		return result.toString();
    }
	public void showListList(List<List<Integer>> temp)
	{
		for(List<Integer> line:temp)
		{
			for(int i:line)
				System.out.println(i);
			System.out.println();
		}
	}
}
