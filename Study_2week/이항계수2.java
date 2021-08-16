import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n,k ;
	static long[][] combi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		combi = new long[n+1][k+1];
		
		if(k==0) {
			System.out.println("1");
			System.exit(0);
		}
		
		System.out.println(make_combi(n, k));
	}
	
	public static long make_combi(int x, int y) {
		if(combi[x][y]>0) return combi[x][y];
		if (x==y||y==0) {
			return combi[x][y]=1;
		}
		return combi[x][y] = (make_combi(x-1,y-1)+make_combi(x-1,y))%10007;
	}
	
}
