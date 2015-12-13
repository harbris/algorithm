package algorithm.algospot;

import java.util.HashMap;
import java.util.Scanner;

public class Allergy {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
 		
		Scanner scan = new Scanner(System.in);
        int testCase = Integer.parseInt(scan.nextLine());
        
        for(int i = 0 ; i < testCase ; i++){

        	String[] base = scan.nextLine().split(" ");
        	int mealCount = Integer.parseInt(base[1]);
            String[] friends =  scan.nextLine().split(" ");
            HashMap<String,String> hm = new HashMap<String,String>();
            for(int j = 0 ; j < friends.length ; j++){
            	hm.put(friends[j], "Y");
            }
           
            int resultMealCount = 0;
            
            for(int j = 0 ; j < mealCount ; j++){
            	String[] mealInfo =  scan.nextLine().split(" ");
            	boolean mealCheck = true;
            	for(int k = 1 ; k < mealInfo.length ; k++){
            		if(hm.get(mealInfo[k]) == "Y"){
            		   hm.put(mealInfo[k], "N");	
            		}else{
            		   mealCheck = false;
            		}
            		//if(!mealCheck) mealCheck = true;
            	}
            	
            	if(mealCheck) resultMealCount += 1;
            }
            
            System.out.println(resultMealCount);
        }
	}

}
