package bfs;
import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> start = new HashSet<>();
		Set<String> end = new HashSet<>();

		int len = 1;
		Set<String> visited = new HashSet<>();

		start.add(beginWord);
		end.add(endWord);
		while(!start.isEmpty() && !end.isEmpty()){
			if(start.size() > end.size()){
				Set<String> tmp = start;
				start = end;
				end = tmp;
			}

			Set<String> temp = new HashSet<>();			
			for(String word : start){
				char[] chs = word.toCharArray();
				
				for(int i = 0; i < chs.length; i++){
					for(char c = 'a'; c <= 'z'; c++){
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);
						
						if(end.contains(target)){
							return len + 1;
						}
						
						if(!visited.contains(target) && wordList.contains(target)){
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}
			start = temp;
			len++;
		}
		return 0;
	}
	
	
	public static void main(String args[]){
		String wordList[] = {"hot","dog", "dot"};
		Set<String> set = new HashSet<>(Arrays.asList(wordList));
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength("hot", "dog", set)); 
	}
}
