package dp;

public class SentenceScreenFitting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int length = s.length();
		int start = 0;
		for(int i = 0; i < rows; i++){
			start += cols;
			if(s.charAt(start % length) == ' '){
				start++;
			}else{
				while(start > 0 && s.charAt((start - 1) % length) != ' '){
					start--;
				}
			}
		}
		
		return start / length;
	}
	
	public static void main(String args[]){
		SentenceScreenFitting scf = new SentenceScreenFitting();
		String nums[] = {"the", "word", "is", "a", "mess"};
		System.out.println(scf.wordsTyping(nums, 4, 5));
	}
}
