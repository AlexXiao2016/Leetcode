package design;
import java.util.*;

public class DesignSnakeGame {
	
	class Position{
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	int width, height, length;
	int[][] food;
	LinkedList<Position> snack;
	
	public DesignSnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		
		snack = new LinkedList<>();
		snack.add(new Position(0, 0));
		length = 0;
	}
	
	public int move(String direction){
		Position cur = new Position(snack.get(0).x, snack.get(0).y);
		
		switch(direction){
		case "U":
			cur.x--;
			break;
		case "D":
			cur.x++;
			break;
		case "L":
			cur.y--;
			break;
		case "R":
			cur.y++;
			break;
		}
		
		if(cur.x < 0 || cur.x == height || cur.y < 0 || cur.y == width) return -1;
		
		for(int i = 0; i < snack.size() - 1; i++){
			Position next = snack.get(i);
			if(cur.x == next.x && cur.y  == next.y){
				return -1;
			}
		}
		
		snack.addFirst(cur);
		if(length < food.length){
			Position temp = new Position(food[length][0], food[length][1]);
			if(cur.x == temp.x && cur.y == temp.y){
				length++;
			}
		}
		
		while(snack.size() > length + 1) snack.removeLast();
		return length;
	}
}
