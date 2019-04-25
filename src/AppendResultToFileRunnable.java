import java.io.IOException;

public class AppendResultToFileRunnable implements Runnable {

	BlockingQueue q2;
	private String processedData;

	public AppendResultToFileRunnable(BlockingQueue q2) {
		this.q2 = q2;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				processedData = (String) q2.pop();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				FileUtils.appendStringToFile("NewFile.txt", processedData);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}