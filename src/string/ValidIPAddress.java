package string;

public class ValidIPAddress {
	public String validIPAddress(String IP) {
        if(isValidIPv4(IP)) return "IPv4";
        if(isValidIPv6(IP)) return "IPv6";
        return "Neither";
    }
    
    private boolean isValidIPv4(String IP){
        if(IP.length() < 7) return false;
        if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return false;
        String[] tokens = IP.split("\\.");
        if(tokens.length != 4) return false;
        for(String token : tokens){
            if(!isValidIPv4Token(token)) return false;
        }
        return true;
    }
    
    private boolean isValidIPv4Token(String token){
    	if(token.length() > 1 && token.charAt(0) == '0') return false;
        try{
            int ip = Integer.valueOf(token);
            if(ip < 0 || ip > 255) return false;
            if(ip == 0 && token.charAt(0) != '0') return false;
        }catch(Exception ex){
            return false;
        }
        return true;
    }
    
    private boolean isValidIPv6(String IP){
        if(IP.length() < 15) return false;
        if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return false;
        String tokens[] = IP.split(":");
        if(tokens.length != 8) return false;
        for(String token : tokens){
            if(!isValidIPv6token(token)) return false;
        }
        return true;
    }
    
    private boolean isValidIPv6token(String token){
        if(token.length() > 4 || token.length() == 0 || token.charAt(0) == ':') return false;
        char[] chars = token.toCharArray();
        for(char c : chars){
            boolean isDigit = c >= '0' && c <= '9';
            boolean isChar = (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
            if(!(isDigit || isChar)){
            	return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
    	ValidIPAddress vp = new ValidIPAddress();
    	String ip = "192.0.0.1";
    	System.out.println(vp.validIPAddress(ip));
    }
}
