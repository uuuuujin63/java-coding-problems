
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Character> key = new LinkedList<>();
	static node e;
	static boolean[][][] v;
	static char[][] map;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m][1<<6];
		node s = null;
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(map[i][j]=='0') {
					s = new node(i, j, 0);
				}
			}
		}
		System.out.println(bfs(s));
		
	}
	
	public static int bfs(node s) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0, -1,0,1};
		
		Queue<node> q = new LinkedList<>();
		q.add(s);
		v[s.x][s.y][0] = true;
		//시작점 좌표, 키가 존재하지 않으므로 0 에 true 방문표시
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int qs=0;qs<size;qs++) {
				node no = q.poll();
				int x = no.x;
				int y = no.y;
				int key = no.key;
				for(int i=0;i<4;i++) {
					int nowx = x+dx[i], nowy = y+dy[i];
					int nowk = key;
					
					if(nowx<0||nowy<0||nowx>=n||nowy>=m) continue;
					//범위 밖
					
					if(map[nowx][nowy]=='1') return cnt;
					//도착지에 도착하면 return
					
					if(map[nowx][nowy]=='#') continue;
					//벽
					
					if('a'<=map[nowx][nowy] && 'f'>=map[nowx][nowy]) {
						nowk|=(1<<map[nowx][nowy]-'a');
					}
					//or 연산을 통해 비트마스킹 해준다.
					//각 자리에 1이 오게되면 그 자리에 해당하는 열쇠를 주은 것.
					
					if('A'<=map[nowx][nowy]&&'F'>=map[nowx][nowy]) {
						if((nowk&(1<<(map[nowx][nowy]-'A')))==0) continue;
						//and 연산을 했을 때 0이 나왔다는 소리는 열쇠가 없다는 것
					}
					//문을 만났을 때
					//열쇠가 없다면 패스한다.
					
					if(v[nowx][nowy][nowk]) continue;
					//이미 왔던 곳이면 패스
					
					v[nowx][nowy][nowk] = true;
					q.add(new node(nowx, nowy, nowk));
					//위에 모든 것에 다 걸리지 않았다면 큐에 넣어줌.
				}
			}
			cnt++;
		}
		return -1;
	}
}
class node{
	int x,y, count, key;

	public node(int x, int y, int key) {
		super();
		this.x = x;
		this.y = y;
		this.key = key;
	}

	

}
