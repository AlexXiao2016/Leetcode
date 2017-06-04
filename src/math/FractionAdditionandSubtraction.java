package math;

public class FractionAdditionandSubtraction {
	public String fractionAddition(String expression) {
		String[] exps = expression.split("(?=[-,+])");
		String res = "0/1";
		for (int i = 0; i < exps.length; i++) {
			res = add(res, exps[i]);
		}
		return res;
	}

	public String add(String s1, String s2) {
		String num1[] = s1.split("/");
		String num2[] = s2.split("/");
		int n1 = Integer.parseInt(num1[0]);
		int d1 = Integer.parseInt(num1[1]);
		int n2 = Integer.parseInt(num2[0]);
		int d2 = Integer.parseInt(num2[1]);

		int n = n1 * d2 + n2 * d1;
		int d = d1 * d2;

		if (n == 0)
			return "0/1";
		int sign = 1;
		if (n / d < 0)
			sign = -1;
		int gcd = gcd(Math.abs(n), Math.abs(d));
		return (sign == -1 ? "-" : "") + (n / gcd) + "/" + (d / gcd);
	}

	private int gcd(int a, int b) {
		if (b == 0 || a == 0)
			return a + b;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		FractionAdditionandSubtraction eg = new FractionAdditionandSubtraction();
		eg.fractionAddition("-5/1+8/1+1/1");
	}
}
