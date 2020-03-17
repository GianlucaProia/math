package math.com.controllers;

public class MyClass implements Runnable {

	public void run() {
		 while (true){
		       if (true){
		    	   System.out.println("MyClass is running!!!");
		       }
		       try {
				java.lang.Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	   }
}