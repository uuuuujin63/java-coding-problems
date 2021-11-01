import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// n : 트럭의 수
		int w = Integer.parseInt(st.nextToken());
		// w : 다리의 길이
		int l = Integer.parseInt(st.nextToken());
		// l : 다리의 최대 하중

		st = new StringTokenizer(br.readLine());
		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<w;i++) {
			q.add(0);
		}
		// 다리 길이만큼 0 담기

		int w_sum = 0;
		// 다리위에 올라간 트럭의 합
		int time = 0;
		while (true) {
			time++;
			w_sum -= q.poll();
			if (!truck.isEmpty()) {
				if (truck.peek() + w_sum <= l) {
					w_sum += truck.peek();
					q.add(truck.poll());
				}else {
					q.add(0);
				}
			}
			if(q.isEmpty()) break;
		}
		System.out.println(time);
	}
}
