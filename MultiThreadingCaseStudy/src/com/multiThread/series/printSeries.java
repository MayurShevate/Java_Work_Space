package com.multiThread.series;



public class printSeries implements Runnable {

	int num;

	public printSeries(int num) {
		this.num = num;

	}

	@Override
	public void run() {
		System.out.println( "\n Printing Number series of "+num + "\n");
		synchronized (this) {
			int sum = num;
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + sum);
				sum = sum + num;

			}

		}

	}

	public static void main(String[] args) {

		printSeries n1 = new printSeries(5);
		printSeries n2 = new printSeries(10);
		printSeries n3 = new printSeries(50);
		Thread t1 = new Thread(n1);
		Thread t2 = new Thread(n2);
		Thread t3 = new Thread(n3);

		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();

		try {
			t2.join();
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}

		t3.start();
	}

}
