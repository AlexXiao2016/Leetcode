package string;

public class LongestAbsoluteFilePath {
	public static int lengthLongestPath(String input) {
	    String[] paths = input.split("\n");
	    int[] stack = new int[paths.length + 1];
	    int maxLen = 0;
	    for(String s : paths){
	        int start = s.lastIndexOf("\t") + 1;
	        stack[start + 1] = stack[start] + s.length()- start + 1;
	        int curLen = stack[start + 1];
	        if(s.contains(".")) {
	        	maxLen = Math.max(maxLen, curLen - 1);	        
	        }
	    }
	    return maxLen;
	}
	
	public static void main(String args[]){
		String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(path));
	}
}
