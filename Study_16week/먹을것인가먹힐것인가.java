import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tt=0;tt<t;tt++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr_a = new int[n];
			int[] arr_b = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr_a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				arr_b[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr_b);			
			
			int res = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=m-1;j>=0;j--) {
					if(arr_a[i]>arr_b[j]) {
						//System.out.println(arr_a[i]+" "+arr_b[j]);
						res+=j+1;
						break;
					}
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}


