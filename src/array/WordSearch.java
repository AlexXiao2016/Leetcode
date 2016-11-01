package array;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(board == null || word == null){
			return false;					
		}
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){				
				if(dfs(board, word, i, j, 0) == true){
					return true;
				}
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, String word, int i, int j, int k){
		int row = board.length;
		int col = board[0].length;

		if(i < 0 || j < 0 || i >= row || j >= col){
			return false;
		}

		if(k == word.length()){
			return true;
		}

		if(board[i][j] != word.charAt(k)){
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '#';
		boolean result = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
		board[i][j] = temp;
		
		return result;
	}
}
