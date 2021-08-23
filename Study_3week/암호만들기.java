import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] tmp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		tmp = new char[l];
		char[] alph = new char[c];
		alph = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(alph);
		find_password(0, 0, 0, 0, l, c, alph);
		System.out.println(sb);
	}
	
	public static void find_password(int start, int cnt, int cnt_m, int cnt_j, int l, int c, char[] alph) {
		if(cnt == l) {
			if(cnt_m>=1 && cnt_j>=2) {
				for(int i=0;i<l;i++) {
					sb.append(tmp[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start;i<c;i++) {
			tmp[cnt] = alph[i];
			if(alph[i]=='a'||alph[i]=='e'||alph[i]=='i'||alph[i]=='o'||alph[i]=='u') {
				find_password(i+1, cnt+1, cnt_m+1, cnt_j, l, c, alph);
			}else {
				find_password(i+1, cnt+1, cnt_m, cnt_j+1, l, c, alph);
			}
		}
	}

}
