import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int test = Integer.parseInt(br.readLine());
            String input = br.readLine();
            int n = input.length();
            String str = "";
            for(int i=0;i<n;i++) {
                if(input.charAt(i)==' ') continue;
                str += input.charAt(i);
            }
            n = str.length();
            input = br.readLine();
             
            int res = 0;
            int tmp_n = input.length();
            int cnt = 0;
            for(int i=0;i<tmp_n;i++) {
                if(str.charAt(cnt)==input.charAt(i)) {
                    cnt ++;
                    if(cnt == n) {
                        cnt = 0;
                        res ++;
                    }
                }else {
                    cnt = 0;
                    if(str.charAt(cnt)==input.charAt(i)) cnt++;
                }
            }
             
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}
