
public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.node[index] == null){
                curr.node[index] = new TrieNode();
            }
            curr = curr.node[index];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findNode(word);
        if(node == null){
            return false;
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
    
    private TrieNode findNode(String word){
        if(word == null){
            return null;
        }
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.node[index] == null) {
                return null;
            }
            curr = curr.node[index];
        }
        return curr;
    }
}

class TrieNode {
    // Initialize your data structure here.
    
    TrieNode node[];
    boolean isWord;
    
    public TrieNode() {
        node = new TrieNode[26];
    }
}
