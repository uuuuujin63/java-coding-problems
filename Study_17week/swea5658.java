import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tt=1;tt<=t;tt++	) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			char[] num = br.readLine().toCharArray();
			LinkedList<Character> numlist = new LinkedList<>();
			ArrayList<Integer> pwdList = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				numlist.add(num[i]);
			}
			// 회전하기 쉽도록 list에 담아준다.
			
			for(int i=0;i<n/4;i++) { // 총 n/4번 회전
				ArrayList<Integer> pwd = new ArrayList<>();				
				pwd = getPwd(numlist, n);
				// 16진수->10진수 로 변환한 비밀번호들
				
				for(int j=0;j<pwd.size();j++) {
					if(!pwdList.contains(pwd.get(j))) {
						pwdList.add(pwd.get(j));
						// 만약 없는 숫자라면 비밀번호 리스트에 추가하기.
					}
				}
				
				char tmp = numlist.remove(n-1);
				numlist.add(0, tmp); // 회전
			}

			Collections.sort(pwdList, Collections.reverseOrder());
			// 큰수부터 k번째 있는 숫자므로 reverseOrder 으로 정렬
//			System.out.println(pwdList.toString());
			sb.append("#").append(tt).append(" ").append(pwdList.get(k-1)).append("\n");
		}
		System.out.println(sb);
	}
	public static ArrayList<Integer> getPwd(LinkedList<Character> c, int n) {
		ArrayList<Integer> pwd = new ArrayList<>();
		for(int i=0;i<n;i+=n/4) {
			String tmp = "";
			for(int j=i;j<i+n/4;j++	) {
				tmp += c.get(j);
			}
//			System.out.println(tmp);
//			System.out.println(Integer.parseInt(tmp, 16));
			pwd.add(Integer.parseInt(tmp, 16));
		}
		return pwd;
	}
}
