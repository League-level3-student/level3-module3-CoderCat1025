package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	str = str + new String(characters);
        return str;
    }
    
    public static String reverse(String str) {
    	StringBuilder build = new StringBuilder(str);
    	build.reverse();
    	
        return build.toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder build = new StringBuilder(str);
    	build.insert(index, newChar);
    	
        return build.toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder build = new StringBuilder(str);
    	build.delete(startIndex, endIndex);
    	
        return build.toString();
    }
}