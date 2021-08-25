import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		char[][] arr_s = new char[n][n];
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				if(arr[i][j]=='G') {
					arr_s[i][j] = 'R';
				}else {
					arr_s[i][j]=arr[i][j];
				}
				//적록색약 리스트에는 G를 없애준다.
			}
		}
		int cnt = 0;
		int cnt_s = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]=='R'||arr[i][j]=='G'||arr[i][j]=='B') {
					dfs(i, j, arr, arr[i][j]);
					cnt ++;
				}
				if(arr_s[i][j]=='R'||arr_s[i][j]=='B') {
					dfs(i, j, arr_s, arr_s[i][j]);
					cnt_s ++;
				}
			}
		}
		System.out.println(cnt+" "+cnt_s);
		
	}
	public static void dfs(int x, int y, char[][] map, char a) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int i=0;i<4;i++) {
			int nowx = x+dx[i];
			int nowy = y+dy[i];
			if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue;
			//범위를 넘어가면 패쓰
			if(map[nowx][nowy]=='0') continue;
			//방문한 곳이어도 패쓰

			if(map[nowx][nowy]==a) {
				map[nowx][nowy] = '0';
				dfs(nowx, nowy, map, a);
			}
		}
	}

}
