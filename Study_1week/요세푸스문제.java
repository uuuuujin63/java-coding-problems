import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		sb.append("<");
		while(true) {
			for(int i=1;i<=k;i++) {
				if(i%k==0) {
					sb.append(q.remove());
					if(!q.isEmpty()) sb.append(", ");
				}else {
					q.add(q.remove());
				}
			}
			if(q.isEmpty()) break;
		}
		sb.append(">");
		System.out.println(sb);
	}
}
