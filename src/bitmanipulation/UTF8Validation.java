package bitmanipulation;

public class UTF8Validation {
	public boolean validUtf8(int[] data) {
		int count = 0;
		for(int c : data){
			if(count == 0){
				if((c >> 5) == 0b110) count = 1;
				else if((c >> 4) == 0b1110) count = 2;
				else if((c >> 3) == 0b11110) count = 3;
				else if((c >> 7) != 0) return false;
			}else{
				if((c >> 6) != 0b10) return false;
				count--;
			}
		}
		return count == 0;
	}
	
	public static void main(String args[]){
		int data[] = {230, 136, 145};
		UTF8Validation utf8 = new UTF8Validation();
		utf8.validUtf8(data);
	}
}
