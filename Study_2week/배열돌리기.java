import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rota = Math.min(m, n)/2;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		for(int rr=0;rr<r;rr++) {//회전의갯수
			for(int ro=0;ro<rota;ro++) {//1회전 당 돌려줘야하는 구역?들의 갯수
				int x = ro;
				int y = ro;
				int tmp = map[x][y];
				for(int i=0;i<4;i++) {
					int rep = i%2==0? m-1-(ro*2):n-1-(ro*2);
				
					for(int j=0;j<rep;j++) {
						int nowx = x+dx[i];
						int nowy = y+dy[i];
						if((0<=nowx&&nowx<n)&&(0<=nowy&&nowy<m)) {
							map[x][y] = map[nowx][nowy];
							x = nowx;
							y = nowy;
						}
					}
				}
				map[ro+1][ro] = tmp;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
