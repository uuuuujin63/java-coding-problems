package 원재의메모리복구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char[] bit = br.readLine().toCharArray();
			int len = bit.length;
			char nowbit = '0';
			int ans = 0;
			
			for(int j=0;j<len;j++) {
				if(nowbit != bit[j]) {
					nowbit = bit[j];
					ans++;
				}
			}
			sb.append("#"+(i+1)+" "+ans+"\n");
		}
		System.out.println(sb);
	}

}
