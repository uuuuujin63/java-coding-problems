import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int[] s = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nan = new int[9];
		for(int i=0;i<9;i++) {
			nan[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nan);
		combi(0, 0, 0, nan);
	}
	public static void combi(int start, int cnt, int sum, int[] nan) {
		if(cnt == 7) {
			if(sum==100) {
				for(int i=0;i<7;i++) { 
					System.out.println(nan[s[i]]);
				}
				System.exit(0);
			}
			return;
		}
		if(sum>100) {
			return;
		}
		
		for(int i=start; i<9;i++) {
			s[cnt] = i;
			combi(i+1, cnt+1, sum+nan[i], nan);
		}
	}

	
}
