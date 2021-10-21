package com.multiThread.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class threadMain implements Runnable {

	int n;

	public threadMain(int n) {
		super();
		this.n = n;
	}

	@Override
	public void run() {
		int num = calPrime.calculatePrimeNum(n);
		System.out.println("The " + n + "th Prime number is :" + num);

	}

	public static void main(String[] args) {

		List<Thread> ts = new ArrayList<>();
		Runnable rn = () -> {

			try {

				while (true) {
					Thread.sleep(5000);
					calPrime.getThreadStatus(ts);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		};

		Thread rt = new Thread(rn);
		rt.setDaemon(true);
		rt.start();

		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the  number to get nth prime number and  0 to exit");
			int n = sc.nextInt();

			if (n == 0) {
				break;
			}
			threadMain pm = new threadMain(n);
			Thread t1 = new Thread(pm);
			ts.add(t1);
			t1.setDaemon(true);
			t1.start();

		}
		System.out.println("----------Main Thread Ended-----");

	}

}
