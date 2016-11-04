package stack;

import java.util.*;

public class ImplementStackusingQueues {
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	 // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() != 1){
        	q2.add(q1.poll());
        }
        q1.poll();
        while(!q2.isEmpty()){
        	q1.add(q2.poll());
        }
    }

    // Get the top element.
    public int top() {
    	while(q1.size() != 1){
        	q2.add(q1.poll());
        }
        int res = q1.poll();
        while(!q2.isEmpty()){
        	q1.add(q2.poll());
        }
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
