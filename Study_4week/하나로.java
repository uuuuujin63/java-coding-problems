//크루스칼


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Island implements Comparable<Island>{
		int x, y;
		double w;

		public Island(int x, int y, double w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Island o) {
			// TODO Auto-generated method stub
			if(this.w>o.w) return 1;
			else return -1; //가중치로 정렬 하깅
		}

	}

	static int[] p;
	static int n;

	public static void make() {
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
	}

	public static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py)
			return false;
		if (px <= py) {
			p[py] = px;
		} else {
			p[px] = py;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); // 섬의 개수
			Island[] is = new Island[n];
			p = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				is[i] = new Island(Integer.parseInt(st.nextToken()), 0, 0);
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				is[i].y = Integer.parseInt(st.nextToken());
			}
			
			double tax = Double.parseDouble(br.readLine());
			PriorityQueue<Island> q = new PriorityQueue<>();
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					double now_tax = (tax*Math.pow(Math.sqrt(Math.pow(is[i].x-is[j].x,2)+Math.pow(is[i].y-is[j].y,2)), 2));
					q.add(new Island(i, j, now_tax));
				}
			}
			
			make();
			int cnt = 1;
			double res = 0.0;
			while(!q.isEmpty()) {
				Island now = q.poll();
				if(union(now.x,now.y)) {
					res += now.w;
					cnt ++;
				}
				
				if(cnt == n	) break;
				
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(res)).append("\n");
		}
		System.out.println(sb);
	}

}
