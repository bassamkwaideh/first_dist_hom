import java.io.IOException;


public class GetLetterAndDigitRunnable extends Thread {
	BlockingQueue q1;
	BlockingQueue q2;
	private String rawDataFromFile;
	
	private String processedData;
	private String filename;

	public GetLetterAndDigitRunnable(BlockingQueue q1, BlockingQueue q2) {
		this.q1 = q1;
		this.q2 = q2;
	}

	@Override
	public void run() {
		
		while (q2.count() <= q2.limit) {
			try {
				filename = q1.pop().toString();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				rawDataFromFile = FileUtils.readFileAsString("data\\" + filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
				processedData = filename + Tools.getCountLetterAndDigit(rawDataFromFile);
			try {
				q2.add(processedData);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}



