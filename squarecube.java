import java.util.*;

class RnoThread extends Thread {
	public void run() 
	{
	        Scanner obj = new Scanner(System.in);
	        
		Random random = new Random();
		System.out.println("how many time to create random integer");
		int q = obj.nextInt();
		for (int i = 0; i < q; i++) {
			int randomInt = random.nextInt(100);
			System.out.println("Random Integer generated : " + randomInt);
			if((randomInt%2) == 0) {
				SThread Thread = new SThread(randomInt);
				Thread.start();
			}
			else {
				CThread Thread = new CThread(randomInt);
				Thread.start();
			}
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}
}

class SThread extends Thread {
	int n;

	SThread(int rN) 
	{
		n = rN;
	}

      public void run() {
		System.out.println("Square of " + n + " = " + (n * n));
	          }
}

class CThread extends Thread {
	int n;

	CThread(int rN) {
		n = rN;
	}

	public void run() {
		System.out.println("Cube of " + n + " = " + n*n*n);
	}
}
class squarecube {
	public static void main(String args[]) 
	{
		RnoThread Thread = new RnoThread();
		  Thread.start();
	}
}

