package com.threaddemo.prime;

public class PrimeUtil {
	
	
	
	public static int calculatePrime(int n) {
		
		int number=1;
		int primeNoFounds=0;
		int i;
		
		
		while(primeNoFounds< n) {
			
			number++;
			for( i=2; i<=number && number % i != 0;i++) {
				
		   }
			
			if(i== number) {
				
				primeNoFounds++;
			}
			
			
		}
		
		
		
		
		
		
		
		return number;
		
		
		
		
		
		
		
		
		
	}

}
