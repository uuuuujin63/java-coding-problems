import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] w;
		int[] s;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			w = new int[n];
			s = new int[k];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			int res=0;
			int start = 1, end = 200000;
			outer:while(start<end) {
				int mid = (start+end)/2;
				int cnt = 0;
				int idx = 0;
				for(int i=0;i<n;i++) {
					if(w[i]<=mid) {
						cnt++;
					}else {
						cnt = 0;
					}
					if(cnt == s[idx]) {
						idx++;
						cnt = 0;
					}
					if(idx>=k) {
						// 가능하면
						end = mid;
						res = end;
						continue outer;
					}
				}
				start = mid+1;
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
