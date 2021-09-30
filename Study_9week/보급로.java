
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[][] d = new int[n][n];
			for(int i=0;i<n;i++) {
				String tmp = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j] = tmp.charAt(j)-'0';
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<daji> q = new PriorityQueue<>();
			d[0][0] = 0;
			q.add(new daji(0, 0, 0));
			int[] dx = {0, 0, 1, -1};
			int[] dy = {1, -1, 0, 0};
			
			outer :while(!q.isEmpty()) {
				daji tmp = q.poll();
				int x = tmp.x, y=tmp.y, w=tmp.w;
				for(int i=0;i<4;i++) {
					int nowx = x+dx[i], nowy = y+dy[i];
					if(nowx<0||nowy<0||nowy>=n||nowx>=n) continue;
					//범위를 벗어나면 패스
					if(nowx==n-1&&nowy==n-1) {
						d[nowx][nowy] = d[x][y];
						break outer;
					}
					if(d[nowx][nowy]>d[x][y]+map[nowx][nowy]) {
						d[nowx][nowy] = w+map[nowx][nowy];
						q.add(new daji(nowx, nowy, d[nowx][nowy]));
					}
				}
			}
			sb.append("#").append(tt).append(" ").append(d[n-1][n-1]).append("\n");
		}
		System.out.println(sb);

	}

}
class daji implements Comparable<daji>{
	int x,y,w;

	public daji(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(daji o) {
		// TODO Auto-generated method stub
		return this.w-o.w;
	}
	
}
