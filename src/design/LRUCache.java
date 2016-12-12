package design;
import java.util.*;

public class LRUCache {
	class DLinkedNode{
        int key, value;
        DLinkedNode prev, next;
        
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
        
        public DLinkedNode(){
            this.key = 0;
            this.value = 0;
        }
    }
    
    HashMap<Integer, DLinkedNode> map;
    DLinkedNode head, tail;
    int capacity, count;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = map.get(key);
        if(node == null){
            return -1;
        }
        update(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null){
            if(count == capacity){
                DLinkedNode toDel = tail.prev;
                remove(toDel);
                map.remove(toDel.key);
                count--;
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            add(newNode);
            map.put(key, newNode);
            count++;
        }else{
            node.value = value;
            update(node);
        }
    }
    
    public void add(DLinkedNode node){
        DLinkedNode after = head.next;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        after.prev = node;
    }
    
    public void remove(DLinkedNode node){
        DLinkedNode after = node.next;
        DLinkedNode before = node.prev;
        after.prev = before;
        before.next = after;
    }
    
    public void update(DLinkedNode node){
        remove(node);
        add(node);
    }
	
}
