import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[][] arr;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] oper = new int[r];
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<r;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int o:oper) {
			switch (o) {
			case 1:
				switch_updown();
				break;
			case 2:
				switch_leftright();
				break;
			case 3:
				rotation_right();
				break;
			case 4:
				rotation_left();
				break;
			case 5:
				move_nextArea();
				break;
			case 6:
				move_beforeArea();
				break;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void switch_updown() {
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m;j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[n-1-i][j];
				arr[n-1-i][j] = tmp;
			}
		}
	}
	public static void switch_leftright() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][m-1-j];
				arr[i][m-1-j] = tmp;
			}
		}
	}
	public static void rotation_right() {
		int tmpn = m;
		int tmpm = n;
		int[][] tmparr = new int[tmpn][tmpm];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmparr[j][n-i-1] = arr[i][j];
			}
		}
		arr = tmparr;
		n = tmpn;
		m = tmpm;
	}
	public static void rotation_left() {
		int tmpn = m;
		int tmpm = n;
		int[][] tmparr = new int[tmpn][tmpm];
		for(int i=0;i<tmpn;i++) {
			for(int j=0;j<tmpm;j++) {
				tmparr[i][j] = arr[j][tmpn-i-1];
			}
		}
		arr = tmparr;
		n = tmpn;
		m = tmpm;
	}
	public static void move_nextArea() {
		int[][] tmparr = new int[n][m];
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				tmparr[i][j+m/2] = arr[i][j];
			}
			for(int j=m/2;j<m;j++) {
				tmparr[i+n/2][j] = arr[i][j];
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				tmparr[i-n/2][j] = arr[i][j];
			}
			for(int j=m/2;j<m;j++) {
				tmparr[i][j-m/2]=arr[i][j];
			}
		}
		
		arr = tmparr;
	}
	public static void move_beforeArea() {
		int[][] tmparr = new int[n][m];
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				tmparr[i+n/2][j] = arr[i][j];
			}
			for(int j=m/2;j<m;j++) {
				tmparr[i][j-m/2] = arr[i][j];
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				tmparr[i][j+m/2] = arr[i][j];
			}
			for(int j=m/2;j<m;j++) {
				tmparr[i-n/2][j]=arr[i][j];
			}
		}		
		arr = tmparr;
	}
}
