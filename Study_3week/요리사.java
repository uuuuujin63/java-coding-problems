import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {
	static int n;
	static int[][] arr;
	static int[] select;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			for(int i=0;i<n;i++) { //arr입력받기
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			select = new int[n/2];
			select_ing(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void select_ing(int cnt, int start) {
		if(cnt == n/2) {
			making_food();
			return;
		}
		
		for(int i=start;i<n;i++) {
			select[cnt] = i;
			select_ing(cnt+1, i+1);
		}
	}
	public static void making_food() {
		int[] nonselect = new int[n/2]; 
		
		int cnt = 0;
		for(int i=0;i<n;i++	) { //선택되지 않은 배열
			int num = i;
			if(!IntStream.of(select).anyMatch(x-> x == num)) {
				nonselect[cnt] = i;
				cnt++;
				if(cnt == n/2) break;
			}
		}
		int sel =0, non_sel=0;
		for(int i=0;i<n/2;i++) {
			for(int j=i;j<n/2;j++) {
				sel += arr[select[i]][select[j]];
				sel += arr[select[j]][select[i]];
				non_sel += arr[nonselect[i]][nonselect[j]];
				non_sel += arr[nonselect[j]][nonselect[i]];
			}
		}
		
		int res = Math.abs(sel-non_sel);
		min = Math.min(min, res);
	}
	
	
}
