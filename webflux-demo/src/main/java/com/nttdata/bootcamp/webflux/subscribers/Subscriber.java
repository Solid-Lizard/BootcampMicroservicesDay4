package com.nttdata.bootcamp.webflux.subscribers;

public class Subscriber {
	public static void print (Integer n) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Subscriber 1: " + n);		
	}
}
