import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int test = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			HashMap<String, Integer> num = new HashMap<>();
			num.put("ZRO", 0);
			num.put("ONE", 0);
			num.put("TWO", 0);
			num.put("THR", 0);
			num.put("FOR", 0);
			num.put("FIV", 0);
			num.put("SIX", 0);
			num.put("SVN", 0);
			num.put("EGT", 0);
			num.put("NIN", 0);
			num.put("ZRO", 0);
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<n;i++) {
				String tmp = st.nextToken();
				int cnt = num.get(tmp);
				num.put(tmp, cnt+1);
			}
			
			int[] cnt = {num.get("ZRO"), num.get("ONE"), num.get("TWO"), num.get("THR"), num.get("FOR"), num.get("FIV"), num.get("SIX"), num.get("SVN"), num.get("EGT"), num.get("NIN")};
			String[] name = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
			
			sb.append("#").append(t).append("\n");
			
			for(int i=0;i<10;i++) {
				for(int j=0;j<cnt[i];j++) {
					sb.append(name[i]).append(" ");
				}
			}
			sb.append("\n");
			//			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
