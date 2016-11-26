package bfs;
import java.util.*;

public class SurroundedRegions {
	public void solve(char[][] board) {
        if(board == null || board.length < 2 || board[0].length < 2) return;
        
        int m = board.length, n = board[0].length;
        for(int i = 0; i < n; i++){
        	if(board[0][i] == 'O'){
        		dfs(board, 0, i, m, n);
        	}
        	if(board[m - 1][i] == 'O'){
        		dfs(board, m - 1, i, m, n);
        	}        	
        }
        
        for(int i = 0; i < m; i++){
        	if(board[i][0] == 'O'){
        		dfs(board, i, 0, m, n);
        	}
        	if(board[i][n - 1] == 'O'){
        		dfs(board, i, n - 1, m, n);
        	}
        }
                
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void bfs(char[][] board, int i, int j, int m, int n){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        board[i][j] = 'A';
        while(!queue.isEmpty()){
        	Node cur = queue.poll();
        	int x = cur.x;
        	int y = cur.y;
        	
        	if(x > 0 && board[x - 1][y] == 'O'){
        		queue.offer(new Node(x - 1, y));
        		board[x - 1][y] = 'A';
        	}
        	
        	if(x + 1 < m && board[x + 1][y] == 'O'){
        		queue.offer(new Node(x + 1, y));
        		board[x + 1][y] = 'A';
        	}
        	
        	if(y > 0 && board[x][y - 1] == 'O'){
        		queue.offer(new Node(x, y - 1));
        		board[x][y - 1] = 'A';
        	}
        	
        	if(y + 1 < n && board[x][y + 1] == 'O'){
        		queue.offer(new Node(x, y + 1));
        		board[x][y + 1] = 'A';
        	}
        }
    }
    
    public void dfs(char[][] board, int i, int j, int m, int n){
    	if(board[i][j] != 'O') return;
    	    	
    	board[i][j] = 'A';    	
    	if(i > 1) dfs(board, i - 1, j, m, n);
    	if(i < m - 2) dfs(board, i + 1, j, m, n);
    	if(j > 1) dfs(board, i, j - 1, m, n);
    	if(j < n - 2) dfs(board, i, j + 1, m, n);
    }
    
    private class Node{
    	int x;
    	int y;
    	Node(int x, int y){                                                                        
    		this.x = x;
    		this.y = y;
    	}
    }
    
    public static void main(String args[]){
    	char[][] board = {{'X','O','X','O','X','O'}, {'O','X','O','X','O','X'}, {'X','O','X','O','X','O'}, {'O','X','O','X','O','X'}}; 
    	SurroundedRegions sr = new SurroundedRegions();
    	sr.solve(board);
    }
}
