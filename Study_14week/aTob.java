import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long a,b;
	static int minn = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		make(0, a);
		if(minn == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(minn);
	}
	public static void make(int cnt, long n) {
		if(n==b) {
			minn = Math.min(minn, cnt+1);
			return;
		}
		if(n>b) {
			return;
		}
		
		if(n*2<=b)
			make(cnt+1, n*2);
		if((n*10+1)<=b)
			make(cnt+1, n*10+1);
	}
}

