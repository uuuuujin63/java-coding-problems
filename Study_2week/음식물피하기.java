import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int res, tmp_res;
	static int n, m;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==1) {
					tmp_res = 0;
					dfs(i, j);
					res = Math.max(res, tmp_res);
				}
			}
		}
		System.out.println(res);
	}
	
	public static void dfs(int x, int y) {
		map[x][y] = 0;
		tmp_res ++ ;
		for(int k=0;k<4;k++	) {
			int nowx = x+dx[k];
			int nowy = y+dy[k];
			if((1<=nowx&&nowx<n+1)&&(1<=nowy&&nowy<m+1)&&(map[nowx][nowy]==1)) {
				dfs(nowx, nowy);
			}
		}
	}
	
}
