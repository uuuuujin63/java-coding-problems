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
		int[] pNum = {2, 3, 5, 7, 11, 13, 17};
		for (int t = 1; t <= T; t++) {
			double res = 0;
			st = new StringTokenizer(br.readLine());
			double a_p = Double.parseDouble(st.nextToken())/100.0;
			double b_p = Double.parseDouble(st.nextToken())/100.0;
			
			double res_a = 0;
			double res_b = 0;
			
			// pNUM[i] 만큼 완제품을 만들 확률구하기
			for(int i=0;i<7;i++) {
				// pNum[i]만큼 18개 중에 뽑는 경우 x pNum[i]만큼 만드는 데 성공할 확률 x pNum[i]개 만들기 실패할 확률
				res_a += combi(18, pNum[i])*Math.pow(a_p, pNum[i])*Math.pow(1-a_p, 18-pNum[i]);
				res_b += combi(18, pNum[i])*Math.pow(b_p, pNum[i])*Math.pow(1-b_p, 18-pNum[i]);
			}
			
			// a가 될 확률 + b가 될 확률 - 교집합
			res = res_a + res_b - res_a*res_b;
			
			sb.append("#").append(t).append(" ").append(String.format("%.6f", res)).append("\n");
		}
		System.out.println(sb);
	}
	
	// nCr = n-1Cr-1 + n-1Cr , nC0 = 1
	public static int combi(int n, int r) {
		if (n==r || r==0) return 1;
		else {
			return combi(n-1, r-1)+combi(n-1,r);
		}
	}
}
