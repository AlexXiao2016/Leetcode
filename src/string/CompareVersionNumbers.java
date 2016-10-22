package string;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if(version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0){
			return 0;
		}
		
		String[] charVer1 = version1.split("\\.");
		String[] charVer2 = version2.split("\\.");
		
		int i = 0;
		while(i < charVer1.length || i < charVer2.length){
			int v1 = 0, v2 = 0;
			if(i < charVer1.length){
				v1 = Integer.valueOf(charVer1[i]);
			}
			if(i < charVer2.length){
				v2 = Integer.valueOf(charVer2[i]);
			}
			if(v1 < v2){
				return -1;
			}
			if(v1 > v2){
				return 1;
			}
			i++;
			
		}
		
		return 0;
	}
}
