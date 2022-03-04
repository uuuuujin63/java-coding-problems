import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			List<Integer>[] g = new LinkedList[v];
			// 부모와 자식을 연결하는 그래프. 조상을 거슬러 올라가 찾아야하기 때문에 반대로 담아줄 것임
			List<Integer>[] origin_g = new LinkedList[v];
			
			for(int i=0;i<v;i++) {
				g[i] = new LinkedList<Integer>();
				origin_g[i] = new LinkedList<Integer>();
			}
			// 초기화
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<e;i++) {
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				origin_g[a].add(b);
				g[b].add(a);
			}
			
			boolean[] x_v = new boolean[v];
			boolean[] y_v = new boolean[v];
			// 방문처리 겸 겹치는 조상 찾기
			
			Queue<Integer> q = new LinkedList<>();
			
			// x의 조상들 찾기
			q.add(x);
			x_v[x] = true;
			while(!q.isEmpty()) {
				int p = q.poll();
				
				for(int c:g[p]) {
					if(x_v[c]) continue;
					
					x_v[c] = true;
					q.add(c);
				}
			}
			
			// y의 조상들 찾기 겸, x와 겹치는 조상 찾기
			q = new LinkedList<>();
			q.add(y);
			y_v[y] = true;
			
			
			int common_p = -1;
			
			outer:while(!q.isEmpty()) {
				int p = q.poll();
				
				for(int c:g[p]) {
					if(y_v[c]) continue;
					if(x_v[c]) {
						// 겹치는 조상을 찾았다면, 종료
						common_p = c;
						break outer;
					}
					x_v[c] = true;
					q.add(c);
				}
			}
			
			// 겹치는 가장 가까운 조상의 서브트리 개수 구하기
			int cnt = 1; 
			q = new LinkedList<>();
			q.add(common_p);
			y_v = new boolean[v];
			// 방문처리를 위해 배열 재활용하기
			y_v[common_p] = true;
			
			outer:while(!q.isEmpty()) {
				int p = q.poll();
				
				for(int c:origin_g[p]) {
					y_v[c] = true;
					q.add(c);
					cnt ++;
				}
			}
			
			sb.append("#").append(t).append(" ").append((common_p+1)).append(" ").append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
}
