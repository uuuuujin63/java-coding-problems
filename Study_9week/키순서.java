import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine().trim());
		for(int tt=1;tt<=t;tt++) {
			int n = Integer.parseInt(br.readLine().trim());
			int m = Integer.parseInt(br.readLine().trim());
			LinkedList<Integer>[] g1 = new LinkedList[n];
			LinkedList<Integer>[] g2 = new LinkedList[n];
			for(int i=0;i<n;i++) {
				g1[i] = new LinkedList<Integer>();
				g2[i] = new LinkedList<Integer>();
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				g1[a].add(b);
				g2[b].add(a);
			}
			int res = 0;
			
			for(int i=0;i<n;i++) {
				int count = 1;
				//자식확인
				boolean[] v = new boolean[n];
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				v[i] = true;
				
				while(!q.isEmpty()) {
					int x = q.poll();
					for(int nowx:g1[x]) {
						if(v[nowx]) continue;
						//이미 방문한 곳이면 패스
						
						v[nowx] = true;
						q.add(nowx);
						count++;
					}
				}
				
				q.add(i);
				while(!q.isEmpty()) {
					int x = q.poll();
					for(int nowx:g2[x]) {
						if(v[nowx]) continue;
						//이미 방문한 곳이면 패스
						
						v[nowx] = true;
						q.add(nowx);
						count++;
					}
				}
				
				if(count==n) {
					res++;
				}
			}
			sb.append("#").append(tt).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

}
