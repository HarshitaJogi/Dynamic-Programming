/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
             long n = sc.nextLong();
            System.out.println(func(n));
        }
	
	}
	
	static long func(long n){
	    
	    if(n<12) return n;
	    
	    else{
	        long sum = Math.max(n, func(n/2) + func(n/3) + func(n/4));
	    
	        return sum;
	    }
	    
	}
}
