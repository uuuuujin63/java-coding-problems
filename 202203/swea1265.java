import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			long res = 1;
			
			int x = n/p;
			int rema = n%p;
			
			for(int i=0;i<p-rema;i++) {
				res *= x;
			}
			
			for(int i=0;i<rema;i++) {
				res *= (x+1);				
			}
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
