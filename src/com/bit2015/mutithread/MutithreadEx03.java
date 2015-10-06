package com.bit2015.mutithread;

public class MutithreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new Thread( new AlphabetRunnableImpl() );
		
		thread1.start();
		thread2.start();
	}

}
