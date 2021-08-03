import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<11;tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");
			int[] box = new int[100];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			Arrays.sort(box);
			if(box[0]==box[99]||box[0]+1==box[99]) {
				sb.append("0");
				break;
			}
			for(int i=1;i<=n;i++) {
				Arrays.sort(box);
				box[99]-=1;
				box[0]+=1;
				
				if(box[0]==box[99]||box[0]+1==box[99]) {
					break;
				}
			}
			Arrays.sort(box);
			ans = box[99]-box[0];
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

}
