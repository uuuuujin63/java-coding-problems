import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String[] num = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
		for (int t = 1; t <= T; t++) {
			int res = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			// n : 배열의 세로 크기
			int m = Integer.parseInt(st.nextToken());
			// m : 배열의 가로 크기
			int realRes = 0;
			
			String[] str = new String[n];
			
			for(int i=0;i<n;i++) {
				str[i] = br.readLine();
			}
			
			int idx = 0;
			// 암호코드를 찾기 위한 인덱스
			
			// 암호코드가 있는 index 찾기
			outer:for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(str[i].charAt(j)=='1') {
						break outer;
					}
				}
				idx ++ ;
			}
			
			// 암호코드는 무조건 1로 끝나니까 뒤에서부터 1이 처음으로 나오는 곳을 찾음.
			int endIdx = 0;
			for(int i=m-1;i>=0;i--) {
				if(str[idx].charAt(i)=='1') {
					endIdx = i;
					break;
				}
			}
			
//			System.out.println(endIdx);
			
			for(int i=0;i<8;i++) {
//				System.out.println(str[idx].substring(endIdx-i*7-6, endIdx-i*7+1));
//				System.out.println((endIdx-i*7-8) +" "+(endIdx-i*7));
				for(int j=0;j<10;j++) {
					if(str[idx].substring(endIdx-i*7-6, endIdx-i*7+1).equals(num[j])) {
						// 부합하는 숫자를 찾기. ex) 0001011 와 num[9]가 같은지 
						res += i%2==1 ? j*3 : j;
						realRes += j;
					}
				}
			}
			
			
//			System.out.println(res);
			res = res%10 == 0 ? realRes : 0;
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
