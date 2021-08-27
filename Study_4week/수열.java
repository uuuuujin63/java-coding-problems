import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n==1) {
			System.out.println("1");
			System.exit(0);
		}
		
		int res = 1;
		
		for(int i=0;i<n-1;i++) {
			int cnt = 1;
			for(int j=i+1;j<n;j++) {
				if(arr[j-1]<=arr[j]) cnt++;
				else break;
			}
			res = Math.max(cnt, res);
		}
		
		for(int i=n-1;i>=1;i--) {
			int cnt = 1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j+1]<=arr[j]) cnt++;
				else break;
			}
			res = Math.max(cnt, res);
		}
		System.out.println(res);
	}

}
