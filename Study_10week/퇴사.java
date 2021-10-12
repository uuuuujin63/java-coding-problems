import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		couns[] c = new couns[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			c[i] = new couns(t, p);
		}
		
		int[] m = new int[n+1];
		
		for(int i=0;i<n;i++) {
			int t = c[i].t;
			int p = c[i].p;
			
			if(i+t>n) {
				m[i+1] = Math.max(m[i+1], m[i]);
				continue;
			}
			//범위를 벗어나면 비교하지 않고 넘어간다.
			
			m[i+t] = Math.max(m[i+t], m[i]+p);
			m[i+1] = Math.max(m[i+1], m[i]);
		}
		System.out.println(m[n]);
	}
}

class couns {
	int t, p;

	public couns(int t, int p) {
		super();
		this.t = t;
		this.p = p;
	}
	
}
