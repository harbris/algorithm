package algorithm.algospot;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;

//id:URI
public class Uri {
	
	//hint : 
	//$ 
	//%2528
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("%20", "hm1| ");
		hm.put("%21", "hm2|!");
		hm.put("%24", "hm3|"+Matcher.quoteReplacement("$"));
		hm.put("%25", "hm4|%");
		hm.put("%28", "hm5|(");
		hm.put("%29", "hm6|)");
		hm.put("%2a", "hm7|*");
		
		int cases = sc.nextInt();
		while(cases-- > 0) {
	    	String str = sc.next();
	    	for( String key : hm.keySet() ){
	    		str = str.replaceAll(key, (hm.get(key)).split("\\|")[0]);
	    	}
	    	
	    	for( String key : hm.keySet() ){
	    		String[] values = (hm.get(key)).split("\\|");
	    		str = str.replaceAll(values[0], values[1]);
	    	}
	    	
	    	System.out.println(str);
	    }
	}
}


