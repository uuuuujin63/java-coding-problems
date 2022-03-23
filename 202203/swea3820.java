import java.util.PriorityQueue;

class UserSolution {

	public static int MinRailSpeed(int N, int[] a, int[] b) {
		int answer = 0;
		PriorityQueue<Rail> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(new Rail(a[i], b[i]));
		}

		long v = 1;
		for (int i = 0; i < N; i++) {
			Rail r = pq.poll();
			v = ((r.a * v) % 1000000007 + r.b) % 1000000007;
		}
		answer = (int) v;
		return answer;
	}
}

class Rail implements Comparable<Rail> {
	long a;
	long b;

	public Rail(long a, long b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Rail o) {
		if (this.b * (o.a - 1) < o.b * (this.a - 1)) {
			return -1;
		} else {
			return 1;
		}
	}
}
