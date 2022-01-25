package leetcode;

import java.util.HashMap;
import java.util.Map;
;

/*
 * Leetcode 146
 * LRU »º´æ»úÖÆ
 */
public class LRUCache {
	class BiLinkedNode
	{
		int key;
		int value;
		BiLinkedNode pre;
		BiLinkedNode next;
		public BiLinkedNode() {}
		public BiLinkedNode(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	Map<Integer, BiLinkedNode> cacheMap = new HashMap<>();
	int size = 0;
	BiLinkedNode start = new BiLinkedNode();
	BiLinkedNode end = new BiLinkedNode();
	
	public LRUCache(int capacity)
	{
		this.size = capacity;
		start.next = end;
		end.pre = start;
	}
	public void movetoStart(BiLinkedNode node)
	{
		BiLinkedNode next = node.next;
		BiLinkedNode pre = node.pre;
		if(next!=null)
		{
			pre.next = next;
			next.pre = pre;
		}
		node.next = start.next;
		node.pre = start;
		start.next.pre = node;
		start.next = node;
	}
	public int get(int key)
	{
		if(this.cacheMap.containsKey(key))
		{
			this.movetoStart(cacheMap.get(key));
			return this.cacheMap.get(key).value;
		}
		else {
			return -1;
		}
	}
	public void addNode(int key, int value)
	{
		BiLinkedNode node = new BiLinkedNode(key,value);
		cacheMap.put(key, node);
		this.movetoStart(node);
	}
	public void put(int key, int value)
	{
		if(cacheMap.containsKey(key))
		{
			BiLinkedNode node = cacheMap.get(key);
			node.value = value;
			this.movetoStart(node);
		}
		else if(cacheMap.size()<size)
		{
			this.addNode(key, value);
		}
		else {
			BiLinkedNode temp = end.pre;
			end.pre = temp.pre;
			temp.pre.next = end;
			cacheMap.remove(temp.key);
			this.addNode(key, value);
		}
	}
}
