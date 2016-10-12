
public class CountPrimes {
	public int countPrimes(int n) {
		int count = 0;
		boolean primes[] = new boolean[n];
		
		for(int i = 2; i * i < n; i++){
			if(primes[i] == false){
				for(int j = i; i * j < n; j++){
					primes[i * j] = true;
				}
			}
		}
		
		for(int i = 2; i < n; i++){
			if(primes[i] == false) count++;
		}
		
		return count;
	}
}
