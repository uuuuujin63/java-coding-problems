//2675번

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			char[] test = st.nextToken().toCharArray();
			int len = test.length;
			for(int j=0;j<len;j++) {
				for(int k=0;k<n;k++) {
					System.out.print(test[j]);
				}
			}
			System.out.println();
		}
	}
}
