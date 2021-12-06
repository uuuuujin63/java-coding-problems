import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int res = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dfs(i, j, 0, 0);
				
				if(i-1<0||i+1>=n||j-1<0||j+1>=m) {
					// ㅏ ㅗ ㅜ ㅓ 중 한 방향만 가능할 때
					// 가능한 부분만 모두 더하면 됨.
					int sum = 0;
					int cnt = 0;
					for(int k=0;k<4;k++) {
						int nowi = i+dx[k];
						int nowj = j+dy[k];
						if(0>nowi||0>nowj||n<=nowi||m<=nowj) continue;
						cnt ++;
						sum+= map[nowi][nowj];
					}
					if(cnt == 3) // 두 방향만 가능한 경우가 있기 때문
						res = Math.max(res, sum+map[i][j]);
				}else {
					// 모든 방향이 가능할 때
					// 자기자신 + 인접한 네방향 합 구한 후 최솟값 하나 뺴주기
					int min_num = Integer.MAX_VALUE;
					int sum = 0;
					for(int k=0;k<4;k++) {
						int nowi = i+dx[k];
						int nowj = j+dy[k];
						if(0>nowi||0>nowj||n<=nowi||m<=nowj) continue;
						sum+= map[nowi][nowj];
						min_num = Math.min(min_num, map[nowi][nowj]);
					}
					res = Math.max(res, sum+map[i][j]-min_num);
				}
			}
		}
		System.out.println(res);
	}
	public static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == 4) {
			// 깊이가 4라면 값 비교 후 정지
			res = Math.max(res, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nowx = x+dx[i], nowy = y+dy[i];
			if(0>nowx||0>nowy||n<=nowx||m<=nowy) continue;
			if(v[nowx][nowy]) continue;
			// 방문했던 곳이라면 컨티뉴
			
			v[nowx][nowy] = true;
			dfs(nowx, nowy, cnt+1, sum+map[nowx][nowy]);
			v[nowx][nowy] = false;
		}
	}
}
