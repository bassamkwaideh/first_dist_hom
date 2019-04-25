
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue q1 = new BlockingQueue(100);
		
		BlockingQueue q2 = new BlockingQueue(100);
		
		ReadFilesRunnable t1 = new ReadFilesRunnable(q1);
		
		Thread th1 = new Thread(t1);
		GetLetterAndDigitRunnable th2[] = new GetLetterAndDigitRunnable[8];

		AppendResultToFileRunnable t3 = new AppendResultToFileRunnable(q2);
		Thread th3 = new Thread(t3);
		
		// Runnable
		th1.start();
		for (int i = 0; i < 8; i++) {
			th2[i] = new GetLetterAndDigitRunnable(q1, q2);
			th2[i].start();

		}

		th3.start();

		
		th1.join();

		for (int i = 0; i < 8; i++) {

			th2[i].join();

		}

		th3.join();

	}

}
