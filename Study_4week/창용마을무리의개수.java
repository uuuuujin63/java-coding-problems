import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int n,m;
    static int[] p;
     
    public static void make() {
        for(int i=0;i<n;i++) {
            p[i]=i;
        }
    }
     
    public static int find(int x) {
        if(p[x]==x) return x;
         
        return p[x] = find(p[x]);
         
    }
     
    public static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
         
        if(px == py) return false;
         
        if(px<=py) {
            p[py] = px;
        }else {
            p[px] = py;
        }
        return true;
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int tc = Integer.parseInt(br.readLine());
         
        for(int t=1;t<=tc;t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //정점
            m = Integer.parseInt(st.nextToken()); //간선
            p = new int[n];
            make();
            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                union(x,y);
            }
            int cnt = 1;
            int[] muri = new int[n];
            muri[0] = find(0);
            for(int i=1;i<n;i++) {
                boolean flg = true;
                for(int j=0;j<cnt;j++) {
                    if(muri[j]==find(i)) {
                        flg = false;
                        break;
                    }
                }
                if(flg) {
                    muri[cnt++] = find(i);
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
 
}
