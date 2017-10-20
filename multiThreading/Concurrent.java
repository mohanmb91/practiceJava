package multiThreading;

public class Concurrent {

	public static void main(String[] args) {
	/* 	
	 	Runnable runnable = () -> {


			System.out.println("I am running in " + Thread.currentThread().getName());
		};
		
		Thread t = new Thread(runnable);;
		t.setName("My Thread");
		
		t.start();  // this will be started by MY Thread
		t.run(); 	// this will be called by main thread.
	 
	 */
		LongWrapper longWrapper = new LongWrapper(0L);
		Runnable runnable = () -> {
			for(int i=0; i < 1_000; i ++){
				longWrapper.incrementValue();
			}
		};
		Thread[] threads = new Thread[1000];
		
		for(int i =0 ; i < 1000; i ++){
			threads[i] = new Thread(runnable);
			threads[i].start();
		}
		
		for(int i=0;i < 1000; i ++){
			try {
				threads[i].join(); // waits for a thread to die.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		 System.out.println(longWrapper.getValue());
	}

}


class LongWrapper{
	private long l;
	
	public LongWrapper(long l){
		this.l = l;
	}
	
	public long getValue(){
		return l;
	}
	
	public synchronized void incrementValue(){
		l = l + 1;
	}
}
