import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			int hn = n%2==0? n/2-1:n/2;
			Queue<String> dq = new LinkedList<String>();
			st = new StringTokenizer(br.readLine());
			sb.append("#"+tc+" ");
			for(int i=0;i<n;i++) {
				if (i>hn) {
					sb.append(dq.remove()).append(" ").append(st.nextToken()).append(" ");
				}else {
					dq.add(st.nextToken());
				}
			}
			if(n%2==1) {
				sb.append(dq.remove());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
