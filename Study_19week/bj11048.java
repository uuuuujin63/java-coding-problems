import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=m;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=m;j++) {
        		map[i][j] += Math.max(map[i][j-1], Math.max(map[i-1][j], map[i-1][j-1]));
        	}
        }
        System.out.println(map[n][m]);
	}
}
