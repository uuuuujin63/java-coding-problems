import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int res, n;
	static int[][] h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		h = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				h[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		h[0][0] = 1;
		h[0][1] = 1;
		int x = 0;
		int y = 1;
		//현재 위치
		int d = 0;
		//d : 0(가로) 1(세로) 2(대각선)
		moving_pipe(x, y, d);
		System.out.println(res);
	}
	public static void moving_pipe(int x, int y, int d) {
		switch (d) {
		case 0:
			if(y+1<n&&h[x][y+1]==0) {
				if(y+1==n-1&&x==n-1) {
					res++;
					return;
				}
				moving_pipe(x, y+1, 0);
			}
			if(x+1<n&&y+1<n) {
				if(h[x+1][y]==0&&h[x][y+1]==0&&h[x+1][y+1]==0) {
					if(x+1==n-1&&y+1==n-1) {
						res++;
						return;
					}
					moving_pipe(x+1, y+1, 2);
				}
			}
			break;

		case 1:
			if(x+1<n&&h[x+1][y]==0) {
				if(x+1==n-1&&y==n-1) {
					res++;
					return;
				}
				moving_pipe(x+1, y, 1);
			}
			if(x+1<n&&y+1<n) {
				if(h[x+1][y]==0&&h[x][y+1]==0&&h[x+1][y+1]==0) {
					if(x+1==n-1&&y+1==n-1) {
						res++;
						return;
					}
					moving_pipe(x+1, y+1, 2);
				}
			}
			break;
		case 2:
			if(y+1<n&&h[x][y+1]==0) {
				if(y+1==n-1&&x==n-1) {
					res++;
					return;
				}
				moving_pipe(x, y+1, 0);
			}
			if(x+1<n&&h[x+1][y]==0) {
				if(x+1==n-1&&y==n-1) {
					res++;
					return;
				}
				moving_pipe(x+1, y, 1);
			}
			if(x+1<n&&y+1<n) {
				if(h[x+1][y]==0&&h[x][y+1]==0&&h[x+1][y+1]==0) {
					if(x+1==n-1&&y+1==n-1) {
						res++;
						return;
					}
					moving_pipe(x+1, y+1, 2);
				}
			}
			break;
		}
	}
}
