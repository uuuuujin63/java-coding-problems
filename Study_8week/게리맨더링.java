import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static LinkedList<Integer>[] g;
	static LinkedList<Integer> s = new LinkedList<>();
	static int res = Integer.MAX_VALUE;
	static int[] po;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		po = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			po[i] = Integer.parseInt(st.nextToken());
		}
		
		g = new LinkedList[n];
		
		for(int i=0;i<n;i++) {
			g[i] = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				int a= Integer.parseInt(st.nextToken())-1;
				g[i].add(a);
			}
		}
		
		for(int i=1;i<=n/2;i++) {
			permu(0, 0, i);
		}
		
		if(res==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(res);
		}
	}
	
	public static void permu(int start, int cnt, int maxi) {
		if(cnt == maxi) {
			bfs_po_check();
			return;
		}
		
		for(int i=start;i<n;i++) {
			s.add(i);
			permu(i, cnt+1, maxi);
			s.remove(cnt);//넣고 빼주기
		}
	}
	
	public static void bfs_po_check() {
		Queue<Integer> q;
		boolean[] v;
		
		q = new LinkedList<>();
		v = new boolean[n];
		q.add(s.get(0));
		v[s.get(0)] = true;
		int count = 1;
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int b:g[a]) {
				if(!v[b]&&s.contains(b)) {
					//b를 방문하지 않았고, s에 b가 포함되어있다면
					q.add(b);
					v[b]=true;
					count++;
				}
			}
		}
		if(count!=s.size()) return;
		
		LinkedList<Integer> ns = new LinkedList<>();
		for(int i=0;i<n;i++) {
			if(s.contains(i)) continue;
			ns.add(i);
		}
		
	
		q = new LinkedList<>();
		v = new boolean[n];
		q.add(ns.get(0));
		v[ns.get(0)] = true;
		count = 1;
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int b:g[a]) {
				if(!v[b]&&ns.contains(b)) {
					//b를 방문하지 않았고, ns에 b가 포함되어있다면
					q.add(b);
					v[b]=true;
					count++;
				}
			}
		}
		if(count!=ns.size()) return;
		
		//여기까지 왔으면 서로 연결되어있는 선거구라는 뜻!
		
		//이제는 인구비교
		int po1 = 0;
		int po2 = 0;
		
		for(int i=0;i<s.size();i++) {
			po1+=po[s.get(i)];
		}
		for(int i=0;i<ns.size();i++) {
			po2+=po[ns.get(i)];
		}
		res = Math.min(res, Math.abs(po1-po2));
		return;
	}
}
