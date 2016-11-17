package greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = -1, tank = 0, min = 0;
		for(int i = 0; i < gas.length; i++){
			tank += gas[i] - cost[i];
			if(tank < min){
				min = tank;
				start = i;
			}
		}
		
		if(tank >= 0){
			return start + 1;
		}else{
			return -1;
		}
	}
}
