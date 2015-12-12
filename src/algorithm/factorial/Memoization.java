package algorithm.factorial;

import static algorithm.factorial.TailCalls.done;
import static algorithm.factorial.TailCalls.call;


public class Memoization {
	static int count = 0;
	public static void main(String[] args) {
		 /* Long[] arr = new Long[11];
		  arr[1] = (long) 1;
		  arr[2] = (long) 1;
		  for (int i = 1 ; i < 11 ; i++) {
	            System.out.println(i+"==>"+fibo_memoization(i,arr) + " ");
	      }
		  
		  for (int i = 1 ; i < 11 ; i++) {
	            System.out.println(i+"==>"+fibo(i) + " ");
	      }
		  
		  System.out.print(count);*/
		
		  System.out.print(factorialTailRec(1,5).invoke());
	}
	
	//recursive and ememoization
	static public long fibo_memoization(int n, Long[] arr){  
		count++;
		long result = 1;
		if (arr[n] == null) {
			result =  (arr[n-1] == null ? fibo_memoization(n-1,arr) : arr[n-1])  
					+ (arr[n-2] == null ? fibo_memoization(n-2,arr) : arr[n-2]);
			arr[n] = result;
        }
		return result;
	}  
	
	//just recursive
	static public long fibo(int n){
		  count++;
		  return n < 2 ? n: fibo(n - 1) + fibo(n - 2);
	}
	
	//recursive and TCO and Ramda
	public static TailCall<Integer> factorialTailRec(final int factorial, final int number){
		if(number == 1)
			return done(factorial);
		else
			return call(() -> factorialTailRec(factorial * number, number-1));
	}
	
}
