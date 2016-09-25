package String;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if(version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0){
			return 0;
		}
		
		String[] charVer1 = version1.split("\\.");
		String[] charVer2 = version2.split("\\.");
		
		int i = 0, j = 0;
		while(i < charVer1.length && j < charVer2.length){
			if(Integer.valueOf(charVer1[i]) > Integer.valueOf(charVer2[j])){
				return 1;
			}else if(Integer.valueOf(charVer1[i]) < Integer.valueOf(charVer2[j])){
				return -1;
			}else{
				i++;
				j++;
			}
		}
		
		if(charVer1.length == charVer2.length){
			return 0;
		}else if(i < charVer1.length){
			return 1;
		}else{
			return -1; 
		}
		
	}
}
