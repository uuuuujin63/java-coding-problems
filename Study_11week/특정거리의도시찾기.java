import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken())-1;
		boolean[] v = new boolean[n];
		ArrayList<Integer>[] g = new ArrayList[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			g[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			g[a].add(b);
		}
		v[x] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				int a = q.poll();
				for(int nowa:g[a]) {
					if(v[nowa]) continue;
					v[nowa] = true;
					q.add(nowa);
				}
			}
			cnt ++;
			
			if(cnt==k) {
				break;
			}
		}
		if(q.size()==0) {
			System.out.println("-1");
			System.exit(0);
		}
		
		while(!q.isEmpty()) {
			pq.add(q.poll());
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+1).append("\n");
		}
		
		System.out.println(sb);
	}
}
