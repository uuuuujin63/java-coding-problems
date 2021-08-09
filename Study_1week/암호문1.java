import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int mn = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			for(int i=1;i<=mn*3;i++) {
				if(i%3 == 1) {
					st.nextToken();
					continue;
				}
				else if(i%3==2) {
					idx = Integer.parseInt(st.nextToken());
				}
				else {
					int append_n = Integer.parseInt(st.nextToken());
					for(int j=0;j<append_n;j++) {
						arr.add(idx+j, Integer.parseInt(st.nextToken()));
					}
				}
			}
			sb.append("#").append(tc);
			for(int i=0;i<10;i++) {
				sb.append(" ").append(arr.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
