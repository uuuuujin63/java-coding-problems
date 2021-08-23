
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer>[] g;
		int[] v;
		Queue<Integer> q;
		for(int t= 1; t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			g = new LinkedList[101];
			q = new LinkedList<>();
			v = new int[101];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<101;i++) {
				g[i] = new LinkedList<Integer>();
			}
			for(int i=0;i<n/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a].add(b); //연결 ! ! !!!!! 단방향
			}
			
			int res = 0;
			int cnt = 0;
			q.add(m); // 시작정점 추가
			v[m] = 1; //방문표시. 첫번째로 왔으므로 1표시
			while(!q.isEmpty()) {//큐가 빌 때까지 반복
				int now = q.poll(); //맨 위에꺼 뺀다.
				int now_size = g[now].size();
				for(int i=0;i<now_size;i++) {
					if(v[g[now].get(i)]!=0) continue; //방문했으면 패스
					q.add(g[now].get(i));
					v[g[now].get(i)] = v[now]+1; //부모보다 하나 더 크게 저장.
					cnt = Math.max(cnt, v[now]+1);
				}
			}
			for(int i=100;i>=0;i--) {
				if(cnt == v[i]) {
					res = i;
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

}
