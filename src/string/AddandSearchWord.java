package string;

public class AddandSearchWord {
	TrieNode root = new TrieNode();
	
	public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
        	if(curr.children[ch - 'a'] == null){
        		curr.children[ch - 'a'] = new TrieNode();
        	}
        	curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    public boolean helper(String s, int index, TrieNode node){
    	if(index > s.length()){
    		return node.isWord;
    	}
    	char c = s.charAt(index);
    	if(c == '.'){
    		for(int i = 0; i < node.children.length; i++){
    			if(node.children[i] != null && helper(s, index + 1, node.children[i])){
    				return true;
    			}
    		}
			return false;
    	}else{
    		return node.children[c - 'a'] != null && helper(s, index + 1, node.children[c - 'a']);
    	}
    }
}

class TrieNode{
	TrieNode children[] = new TrieNode[26];
	boolean isWord = false;
}
