package math;

public class WaterandJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        
        if(z == x || z== y || z == x + y)  return true;
        
        return z % GCD(x, y) == 0;
    }
    
    private int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String args[]){
    	WaterandJugProblem pro = new WaterandJugProblem();
    	pro.canMeasureWater(3, 5, 4);
    }
}
