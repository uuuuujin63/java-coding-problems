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
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] g = new LinkedList[n];
		for(int i=0;i<n;i++) {
			g[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(!g[a].contains(b))
				g[a].add(b);
			if(!g[b].contains(a))
				g[b].add(a);
				// 양방향 연결해주기
		}
		
		int res = n+1; // 케빈 베이커 수가 가장 작은 사람의 index 번호
		int res_kb = 7*n; // 그 사람의 케빈 베이컨 수
		for(int i=0;i<n;i++) {
			// 0번부터 한명씩 비교 시작.
			boolean[] v = new boolean[n];
			v[i] = true;
			int kb_sum = 0; // 케빈베이커
			int kb = 0;
			int cnt = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			outer:while(!q.isEmpty()) {
				int size = q.size();
				kb++;
				for(int j=0;j<size;j++) {
					int now = q.poll();
					for(int x:g[now]) {
						if(v[x]) continue;
						// 이미 방문한 적이있다면 패쓰
						
						cnt ++;
						q.add(x);
						kb_sum += kb;
						v[x] = true;
						if(cnt == n) {
							break outer;
						}
						
					}
				}
			}
			
			if(res_kb>kb_sum) {
				res_kb = kb_sum;
				res = i+1;
			}
		}
		System.out.println(res);
	}
}


