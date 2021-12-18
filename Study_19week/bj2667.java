// 백준 2667번 단지번호 붙이기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i=0;i<n;i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int danjiCnt = 0;
        // danjiCnt : 단지의 총 개수를 카운트하는 변수
        PriorityQueue<Integer> homesCnt = new PriorityQueue<>();
        // homesCnt : 단지 내 집의 수를 저장 후 오름차순으로 출력하기 위함.
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		// 0이면 다음 것 따지깅
        		if(map[i][j]=='0') continue;
        		
        		// 1이면 bfs로 단지 내 집의 수 구하기 ! ! !
        		danjiCnt++;
        		int homeCnt = 1; // homeCnt : 단지 내 집의 수
        		Queue<node> q = new LinkedList<node>();
        		q.add(new node(i, j));
        		map[i][j] = '0';
        		// 방문처리
        		while(!q.isEmpty()) {
        			node now = q.poll();
        			for(int k=0;k<4;k++) {
        				int nowx = now.x+dx[k], nowy = now.y+dy[k];
        				if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue;
        				if(map[nowx][nowy] == '0') continue;
        				q.add(new node(nowx, nowy));
        				map[nowx][nowy] = '0';
        				homeCnt++;
        			}
        		}
        		homesCnt.add(homeCnt);
        	}
        }
        sb.append(danjiCnt).append("\n");
        while(!homesCnt.isEmpty()) {
        	sb.append(homesCnt.poll()).append("\n");
        }
        System.out.println(sb);
	}
}
class node{
	int x, y;

	public node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
