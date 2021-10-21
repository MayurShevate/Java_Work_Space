package com.multiThread.main;

import java.util.List;

public class calPrime {

	public static int calculatePrimeNum(int n) {
		int num = 1, count = 0, i;
		while (count < n) {
			num = num + 1;
			for (i = 2; i <= num; i++) {

				if (num % i == 0) {
					// breaks the loop if the above condition returns true
					break;
				}
			}
			if (i == num) {
				// increments the count variable by 1 if the number is prime
				count = count + 1;
			}
		}

		return num;
	}
	
	
	public static void getThreadStatus(List<Thread> threads) {

		threads.forEach(thread -> {

			System.out.println(" Thread Status is " + thread.getState() + "\n");
		});

	}

}
