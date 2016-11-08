package graph;
import java.util.*;

public class EvaluateDivision {
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, Integer> table = new HashMap<>();
		int length = 0;
		for(String strs[] : equations){
			for(String str: strs){
				if(!table.containsKey(str)){
					table.put(str, length++);
				}
			}
		}
		
		double[][] map = new double[length][length];
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				map[i][j] = (i == j) ? 1.0d : -1.0d;
			}
		}
		for(int i = 0; i < equations.length; i++){
			String[] keys = equations[i];
			int row = table.get(keys[0]);
			int col = table.get(keys[1]);
			map[row][col] = values[i];
			map[col][row] = 1 / values[i];
		}
		
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				for(int k = 0; k < length; k++){
					if(map[j][i] >= 0d && map[i][k] >= 0d){
						map[j][k] = map[j][i] * map[i][k];
					}
				}
			}
		}
		
		double[] result = new double[queries.length];
		for(int i = 0; i < queries.length; i++){
			String[] key = queries[i];
			Integer row = table.get(key[0]);
			Integer col = table.get(key[1]);
			if(row == null || col == null){
				result[i] = -1.0d;
			}else{
				result[i] = map[row][col];
			}
		}
		
		return result;		
	}
	
	public static void main(String args[]){
		String a[][] = {{"a", "b"},{"b", "c"}};
		double values[] = {2.0, 3.0};
		String q[][] = {{"a", "c"}};
		calcEquation(a, values, q);
	}

	
}
