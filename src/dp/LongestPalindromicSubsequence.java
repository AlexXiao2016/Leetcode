package dp;

public class LongestPalindromicSubsequence {
	public static int longestPalindromeSubseq(String s) {
		int[][] longest = new int[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			longest[i][i] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					longest[i][j] = longest[i + 1][j - 1] + 2;
				} else {
					longest[i][j] = Math.max(longest[i + 1][j], longest[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				System.out.print(longest[i][j] + "\t");
			}
			System.out.println();
		}

		return longest[0][s.length() - 1];
	}

	public static void main(String args[]) {
		String s = "bbbabaaaa";
		longestPalindromeSubseq(s);
	}
}
