import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int n =s.length();
		
		int r= 0;
		for(int i=1;i<=Math.sqrt(n);i++) {
			//1부터 루트n까지 n과 나눠지는 값들 중 가장 큰 수를 r에 넣는다.
			if(n%i==0) {
				r = Math.max(r, i);
			}
		}
		int c = n/r;
		
		char[][] msg = new char[r][c];
		int idx = 0;
		for(int j=0;j<c;j++) {
			for(int i=0;i<r;i++) {
				msg[i][j]=s.charAt(idx++);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(msg[i][j]);
			}
		}
		System.out.println(sb);
	}

}
