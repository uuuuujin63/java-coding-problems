import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			Queue<Integer> q = new LinkedList<>();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			outer: while(true) {
				for(int i=1;i<=5;i++) {
					int tmp = q.remove();
					tmp -=i;
					if(tmp<=0) {
						tmp = 0;
						q.add(tmp);
						break outer;
					}
					q.add(tmp);
				}
			}
			sb.append("#"+tc+" ");
			for(int i=0;i<8;i++) {
				sb.append(q.remove() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
