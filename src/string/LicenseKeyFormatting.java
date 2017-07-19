package string;

/**
 * Created by xiaoping on 7/18/17.
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            char ch = S.charAt(i);
            if(ch != '-'){
                sb.append(ch);
                count++;
                if(count % K == 0){
                    sb.append('-');
                    count = 0;
                }
            }
        }
        if(sb.length() == 0)    return "";

        String res = sb.reverse().toString().toUpperCase();
        return res.charAt(0) == '-' ? res.substring(1) : res;
    }

    public static void main(String[] args){
        LicenseKeyFormatting l = new LicenseKeyFormatting();
        System.out.println(l.licenseKeyFormatting("---", 3));
    }
}
