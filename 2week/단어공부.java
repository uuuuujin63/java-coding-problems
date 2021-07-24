//1157번

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toUpperCase().toCharArray();
		int[] cnt = new int[26];
		
		for(char c:word) {
			cnt[c-'A']++;
		}
		
		int mn = -1;
		char ch = '?';
		
		for(int i=0;i<26;i++) {
			if (mn<cnt[i]) {
				mn = cnt[i];
				ch = (char)(i+65);
			}
			else if (mn == cnt[i]) ch = '?';
		}
		System.out.println(ch);
	}
}
