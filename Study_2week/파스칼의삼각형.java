import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n,k ;
	static int[][] tri;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tri = new int[n+1][n+1];
		for(int i=2;i<=n;i++) {
			tri[i][1] = 1;
			tri[i][i] = 1;
		}
		if(n == k || k == 1) {
			System.out.println(1);
			System.exit(0);
		}
		make_tri(3,2);
		System.out.println(tri[n][k]);
	}
	
	//[i][j] = [i-1][j-1]+[i-1][j]
	public static void make_tri(int x, int y) {
		if(x==n&& y==k+1) {
			return;
		}
		if(x==y) {
			make_tri(x+1, 2);
		} else {
			tri[x][y] = tri[x-1][y-1]+tri[x-1][y];
			make_tri(x, y+1);
		}
		
	}
	
}
