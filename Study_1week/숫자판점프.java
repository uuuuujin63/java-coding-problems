import java.io.*;
import java.util.*;


class Main {
	static List<String> list = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int res = 0;
		String[][] map = new String[5][5];

		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j] = st.nextToken();
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(map, i, j, 0, map[i][j]);
			}
		}
		System.out.println(list.size());
	}
	
	public static void dfs(String[][] m, int x, int y, int cnt, String tmp) {
		if(cnt == 5) {
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int nowx = x+dx[i];
			int nowy = y+dy[i];
			if((0<=nowx&&nowx<5)&&(0<=nowy&&nowy<5)) {
				dfs(m, nowx, nowy, cnt+1, tmp+m[nowx][nowy]);
			}
		}
	}
}
