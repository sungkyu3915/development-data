package com.bit2015.mutithread;

public class MutithreadEx01 {

	public static void main(String[] args) {
		
		Thread thread = new DigitThread();
		thread.start();
		
		for( char c = 'A'; c <= 'Z'; c++ ) {
			System.out.print( c );
			try {
				Thread.sleep( 1000 );
			} catch( InterruptedException ex ) {
				ex.printStackTrace();
			}
		}

	}

}
