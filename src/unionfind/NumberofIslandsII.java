package unionfind;
import java.util.*;

public class NumberofIslandsII {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(m <= 0 || n <= 0) return res;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] islands = new int[m * n];
        Arrays.fill(islands, -1);
        int count = 0;
        
        for(int[] p : positions){
            count++;
            int index = n * p[0] + p[1];
            islands[index] = index;
            
            for(int[] dir : dirs){
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                
                int newIndex = n * x + y;
                if(x < 0 || y < 0 || x >= m || y >= n || islands[newIndex] == -1) continue;
                int island = findIslands(islands, newIndex);
                if(island != index){
                    islands[index] = island;
                    index = island;
                    count--;
                }
                
            }
            res.add(count);
        }
        return res;
    }
    
    
    public int findIslands(int islands[], int id){
        while(id != islands[id]) id = islands[id];
        return id;
    }
}
