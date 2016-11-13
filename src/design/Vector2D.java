package design;
import java.util.*;

public class Vector2D implements Iterator<Integer> {

	Queue<Iterator<Integer>> queue;

	public Vector2D(List<List<Integer>> vec2d) {
		queue = new LinkedList<>();
		for(List<Integer> list : vec2d){
			if(list.size() > 0){
				Iterator<Integer> it = list.iterator();
				queue.add(it);
			}
		}
	}

	@Override
	public Integer next() {
		Iterator<Integer> it = queue.peek();
		if(it == null  || !it.hasNext()){
			queue.poll();
			return queue.peek().next();
		}else{
			return it.next();
		}
	}

	@Override
	public boolean hasNext() {
		if(queue.size() == 1){
			return queue.peek().hasNext();
		}
		return !queue.isEmpty();
	}


	public static void main(String args[]){
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		//		list1.add(3);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		//		list2.add(6);
		//		list2.add(7);
		//		list2.add(8);
		//		list2.add(18);

		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(4);
		list3.add(5);
		list3.add(6);
		//		list3.add(12);

		List<List<Integer>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);

		Vector2D  vector = new Vector2D(list);
		while(vector.hasNext()){
			System.out.println(vector.next());
		}
	}
}
