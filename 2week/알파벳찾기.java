//10809번

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] alph = br.readLine().toCharArray();
		int n = alph.length;
		for(char a='a';a<='z';a++) {
			int flg = 1;
			for(int i=0;i<n;i++) {
				if(alph[i]==a) {
					System.out.print(i+" ");
					flg = 0;
					break;
				}
			}
			if(flg == 1) System.out.print("-1 ");
		}
	}
}
