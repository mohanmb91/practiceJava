package thread;

import java.io.*;

class MyClass extends Thread{
	public void run() {
		for(int i=0;i< 10; i ++){
			System.out.println(Thread.currentThread().getId() + " Value "+ i);
		}	
	}
}

public class ThreadPractice {
	public static void  main(String args[]) {
		MyClass instance = new MyClass();
		instance.start();
		MyClass instance1 = new MyClass();
		instance1.start();
	}
}
