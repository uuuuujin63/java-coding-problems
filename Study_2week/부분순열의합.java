import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] arr;
	static int n, s, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		find_sum_s(0, 0, 0);
		if(s==0) {
			res -- ;
		}
		System.out.println(res);
	}
	
	public static void find_sum_s(int cnt, int start, int sum) {
		
		if(sum == s) {
			res++;
		}
		
		if(cnt == n) return;
		
		//System.out.println("cnt : "+cnt+" "+"start : "+start+" sum : "+sum);
		for(int i=start;i<n;i++) {
			find_sum_s(cnt+1, i+1, sum+arr[i]);
		}
	}
	
}
