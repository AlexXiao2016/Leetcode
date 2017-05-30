package math;

public class ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		long[] lengths = { distance(p1, p2), distance(p1, p3), distance(p1, p4), distance(p2, p3), distance(p2, p4),
				distance(p3, p4) };

		long min = lengths[0], max = lengths[0];
		int minCount = 0, maxCount = 0;

		for (long length : lengths) {
			if (length <= min) {
				min = length;
			} else {
				max = length;
			}
		}

		for (long length : lengths) {
			if (length == min) {
				minCount++;
			}
			if (length == max) {
				maxCount++;
			}
		}

		if (minCount == 4 && maxCount == 2)
			return true;
		return false;

	}

	private long distance(int[] p1, int[] p2) {
		return (long) Math.pow(p1[0] - p2[0], 2) + (long) Math.pow(p1[1] - p2[1], 2);
	}
	
	public static void main(String args[]){
		ValidSquare vs = new ValidSquare();
		int p1[] = {1, 0};
		int p2[] = {0, 1};
		int p3[] = {-1, 0};
		int p4[] = {0, -1};
		vs.validSquare(p1, p2, p3, p4);
	}
}
