import java.io.*;
import java.util.*;


class Main {
	static int n, m;
	static int[] card;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		card = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0; // 걍 초기화
		for(int i=0;i<n-2;i++) {
			if(card[i]>m) continue;
			for(int j=i+1;j<n-1;j++) {
				if(card[i]+card[j]>m) continue;
				for(int k=j+1;k<n;k++) {
					if(card[i]+card[j]+card[k]>m) continue;
					int tmp = card[i]+card[j]+card[k];
					if(Math.abs(tmp-m)<Math.abs(res-m)) {
						res = tmp;
					}
				}
			}
		}
		System.out.println(res);
	}
}
