import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> q = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			q.add(Long.parseLong(br.readLine()));
		}
		long res = 0;
		
		while(q.size()!=1) {
			long tmp = q.poll()+q.poll();
			res += tmp;
			q.add(tmp);
		}
		
		System.out.println(res);
	}

}
