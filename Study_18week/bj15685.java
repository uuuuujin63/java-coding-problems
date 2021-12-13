import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static boolean map[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new boolean[101][101];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon(x,y,d,g);
		}
        int answer = 0;
        for (int i = 0; i < 100; i++) {
        	for (int j = 0; j < 100; j++) {
    			if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
    				answer++;
    		}
		}
        System.out.println(answer);
    }
	private static void dragon(int c, int r, int d, int g) {
		ArrayList<Integer> dir = new ArrayList<Integer>();
		dir.add(d);
		for (int i = 0; i < g; i++) {
			for (int j = dir.size() - 1; j >= 0; j--) {
				dir.add((dir.get(j) + 1) % 4);
			}
		}
		map[r][c] = true;
		for (int i = 0; i < dir.size(); i++) {
			r += dx[dir.get(i)];
			c += dy[dir.get(i)];
			map[r][c] = true;
		}
	}
}
