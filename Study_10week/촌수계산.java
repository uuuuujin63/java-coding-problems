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
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		
		int m = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] g = new LinkedList[n];
		
		for(int i=0;i<n;i++) {
			g[i] = new LinkedList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			g[x].add(y);
			g[y].add(x);
		}
		
		int res = -1;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(a);
		int cnt = 1;
		boolean[] v = new boolean[n];
		v[a] = true;
		outer:while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0;i<s;i++) {
				int x = q.poll();
				for(int nowx:g[x]) {
					if(v[nowx]) continue;
					if(nowx==b) {
						res = cnt;
						break outer;
					}
					v[nowx] = true;
					q.add(nowx);
				}
			}
			cnt++;
		}
		System.out.println(res);
	}
}
