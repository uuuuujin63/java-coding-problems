import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int[] m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		m = new int[n+1];
		Arrays.fill(m, Integer.MAX_VALUE);
		m[1] = 0;
		if(n==1) {
			System.out.println("0");
			System.exit(0);
		}
		
		for(int i=2;i<=n;i++) {
			if(i%2==0) {
				m[i] = Math.min(m[i], m[i/2]+1);
			}
			if(i%3==0) {
				m[i] = Math.min(m[i], m[i/3]+1);
			}
			m[i] = Math.min(m[i], m[i-1]+1);
		}
		System.out.println(m[n]);
	}
}

