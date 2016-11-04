package Arrays;
import java.util.*;

public class QueueReconstructionbyHeight {
	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
	}
	
	public static void main(String args[]){
		int nums[][] = {{7,0}, {4, 4}, {7, 1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(nums);
	}
}
