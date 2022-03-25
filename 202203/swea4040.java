import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static final int INF = 10000000;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int res = -1;
			char[] arr = br.readLine().toCharArray();
			int n = arr.length;
			for(int i=1;i<=n;i++) {
				if(n%i==0) {
					boolean c = true;
					for(int j=0;j<n;j++) {
						if(arr[j%i]!=arr[j]) {
							c = false;
							break;
						}
					}
					
					if(c) {
						res = n/i;
						break;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
