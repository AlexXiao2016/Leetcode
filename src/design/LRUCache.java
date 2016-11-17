package design;
import java.util.*;

public class LRUCache {
	private class DLinkedList{
		int key, value;
		DLinkedList prev, next;
		
		public DLinkedList(int key, int value){
			this.key = key;
			this.value = value;
		}
		
		public DLinkedList(){
			this.key = 0;
			this.value = 0;
		}
	}
	
	private HashMap<Integer, DLinkedList> map;
	private int capacity, count;
	private DLinkedList head, tail;
	
	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		this.count = 0;		 
		head = new DLinkedList();
		tail = new DLinkedList();
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key){
		DLinkedList node = map.get(key);
		if(node == null){
			return -1;
		}else{
			
		}
		return node.value;
	}
	
	public void set(int key, int value){

		DLinkedList node = map.get(key);
		if(node == null){
			if(count == capacity){
				DLinkedList del = tail.prev;
				remove(del);
				map.remove(del.key);
				count--;
			}			
			node = new DLinkedList(key, value);
			add(node);
			count++;
		}else{
			node.value = value;
			update(node);			
		}
				
	}
	
	public void add(DLinkedList node){
		DLinkedList after = head.next;
		head.next = node;
		node.next = after;
		node.prev = head;
		after.prev = node;
	}
	
	public void remove(DLinkedList node){
		DLinkedList before = node.prev;
		DLinkedList after = node.next;
		before.next = after;
		after.prev = before;
	}
	
	public void update(DLinkedList node){
		remove(node);
		add(node);		
	}
	
}
