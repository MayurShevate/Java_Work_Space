package com.threaddemo.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeMain implements Runnable {

	 int n;
	 
	
	 public PrimeMain(int n) {
		super();
		this.n = n;
	}


	@Override
		public void run() {
			int num=PrimeUtil.calculatePrime(n);
			System.out.println("The Value of"+n+" th Prime number is :"+num);
			
		}
	
	
	public static void main(String[] args) {

		List<Thread> threads= new ArrayList<>();
		Runnable stateThread =()->{
			
			try {
				
				while(true) {
					Thread.sleep(5000);
					printThreadStatus(threads);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		};
		
		Thread reportedThread = new Thread(stateThread);
		reportedThread.setDaemon(true);
		reportedThread.start();
		

		while(true) {
			
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the nth number to continue \n  0 to exit");
			int n=sc.nextInt();
			
			if (n==0) {
				break;
			}
			PrimeMain pm=new PrimeMain(n);
			Thread t1=new Thread(pm);
			threads.add(t1);
			t1.setDaemon(true);
			t1.start();
			
			
		}
		System.out.println("==== Main Ended ====");

	}

	
	private static void printThreadStatus(List<Thread> threads) {
		
		System.out.println("=====Thread Status=====");
		threads.forEach(thread ->{
			
			System.out.println(thread.getState()+"\n");
		});
		
		
		
	}

}
