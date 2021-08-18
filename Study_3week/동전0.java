import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int flg = n-1;
		for(int i=0;i<n;i++) { 
			coin[i] = Integer.parseInt(br.readLine());
			if(flg==0&&coin[i]>k) {
				flg = i;
			}
		}
		int res = 0;
		for(int i = flg;i>=0;i--) {
			if(coin[i]<=k) {
				res+=(k/coin[i]);
				k = k%coin[i];
			}
			if(k==0) break;
		}
		System.out.println(res);
		
	}
}
