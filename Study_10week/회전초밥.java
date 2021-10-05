import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] chobab = new int[n];
		for(int i=0;i<n;i++) {
			chobab[i] = Integer.parseInt(br.readLine());
		}
		int[] v = new int[d+1];
		int res = 0;
		
		for(int i=0;i<k;i++) {
			if(v[chobab[i]]==0) {
				res++;
			}
			v[chobab[i]]++;
		}
		
		int cnt = res;
		for(int i=1;i<n;i++) {
			if(cnt>=res) {
				if(v[c]==0) {
					res = cnt+1;
				}else {
					res = cnt;
				}
			}
			v[chobab[i-1]]--;
			if(v[chobab[i-1]]==0) {
				cnt--;
			}
			if(v[chobab[(i+k-1)%n]]==0) cnt++;
			v[chobab[(i+k-1)%n]]++;
		}
		System.out.println(res);
	}
}
