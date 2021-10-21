package com.threaddemo.series;

public class NumberSeries implements Runnable {

	int number;

	public NumberSeries(int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("\n"+number + " No. Series Start------>");

		synchronized (this) {
			int total = number;
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + total);
				total = total + number;

			}

		}

	}

	public static void main(String[] args) {

		NumberSeries n1 = new NumberSeries(5);
		NumberSeries n2 = new NumberSeries(10);
		NumberSeries n3 = new NumberSeries(50);
		Thread t1 = new Thread(n1);
		Thread t2 = new Thread(n2);
		Thread t3 = new Thread(n3);

		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t2.start();

		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t3.start();

	}

}
