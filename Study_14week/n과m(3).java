import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static StringBuilder sb;
	static StringBuilder tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		tmp = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		make(1, 0);
		System.out.println(sb);
	}
	public static void make(int start, int cnt) {
		if(cnt == m) {
			sb.append(tmp).append("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			String t = tmp.substring(0);
			tmp.append(i).append(" ");
			make(i, cnt+1);
			tmp = new StringBuilder();
			tmp.append(t);
			
		}
		
	}
}

