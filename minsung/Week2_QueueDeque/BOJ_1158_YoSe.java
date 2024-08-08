import java.util.Scanner;

public class BOJ_1158_YoSe {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		CircularQueue circularQueue = new CircularQueue(N);

		for (int i = 0; i < N; i++) {
			circularQueue.enqueue(i+1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int index = 1;
		while (!circularQueue.isEmpty()) {
			if (index++ % K == 0)
				sb.append(circularQueue.dequeue()).append(", ");
			else {
				circularQueue.enqueue(circularQueue.dequeue());
			}

		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());

	}

}

class CircularQueue {
	private Object[] object;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		this.object = new Object[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean enqueue(Object object) {
		if (isFull()) {
			return false;
		}
		if (isEmpty()) {
			front = 0;
		}
		rear = (rear + 1) % capacity;
		this.object[rear] = object;
		size++;
		return true;
	}

	public Object dequeue() {
		if (isEmpty()) {
			return null;
		}
		Object object = this.object[front];
		this.object[front] = null;
		front = (front + 1) % capacity;
		size--;
		if (isEmpty()) {
			front = -1;
			rear = -1;
		}
		return object;
	}

	public Object peek() {
		if (isEmpty()) {
			return -1;
		}
		return object[front];
	}

	public int getSize() {
		return size;
	}

}
