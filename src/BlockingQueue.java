import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	private List queue;
	public Integer limit;

	private int counter = 0;

	
	public synchronized int count() {
		counter++;

		return counter;

	}

	public BlockingQueue(Integer limit) {
		this.limit = limit;
		queue = new LinkedList();
	}

	public synchronized Boolean isEmpty() {
		return this.queue.size() == 0;
	}

	public synchronized void add(Object o) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(o);
	}

	public synchronized Object pop() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}

class FirstThread extends Thread {
	BlockingQueue q1;

	public FirstThread(BlockingQueue q) {
		this.q1 = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				q1.add("f" + i + ".txt");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}