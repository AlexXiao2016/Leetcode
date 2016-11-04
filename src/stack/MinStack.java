package stack;
import java.util.*;

public class MinStack {
	Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> pq = new Stack<Integer>();
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        st.push(x);
        pq.push(Math.min(x,pq.size() > 0 ? pq.peek() : x));
    }
    
    public void pop() {
        st.pop();
        pq.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
    
    public static void main(String args[]){
    	MinStack s = new MinStack();
    	s.push(5);
    	s.push(6);
    	s.push(4);
    	s.push(7);
    	s.push(2);
    	
    }
}
