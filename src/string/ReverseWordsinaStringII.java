package string;

public class ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
		if(s == null || s.length <= 1){
			return;
		}
		
		swap(s, 0, s.length - 1);
		
		int start = 0;
		for(int i = start; i < s.length; i++){
			if(s[i] == ' '){
				swap(s, start, i - 1);
				start = i + 1;
			}
		}
		
		swap(s, start, s.length - 1);		
	}
	
	private void swap(char[] s, int start, int end){
		while(start < end){
			char ch = s[start];
			s[start++] = s[end];
			s[end--] = ch;
		}
	}
	
	public static void main(String args[]){
		ReverseWordsinaStringII rws = new ReverseWordsinaStringII();
		char s[] = {'t', ' ', 'b'};
		rws.reverseWords(s);
		for(char c : s){
			System.out.print(c);
		}
	}
}
