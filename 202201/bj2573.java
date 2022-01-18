// 2573 빙산

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
        int[][] map = new int[n][m];
        
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<m;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        Queue<node> q = new LinkedList<node>();
        // 빙하가 몇 덩이인지 bfs를 돌리기 위한 큐 생성
        boolean[][] v = new boolean[n][m];
        // 방문처리
        
        int ice = 0; // 빙하가 몇덩이인지 세는 변수
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=1;i<n-1;i++) {
        	for(int j=1;j<m-1;j++) {
        		if(v[i][j]) continue;
        		// 방문했으면 넘어가기 !
        		if(map[i][j]==0) continue;
        		// 빙산이 아니라면 넘어가기 !
        		
        		// 방문되지 않은 빙하라면 큐에 넣고 bfs를 돌리자
        		q.add(new node(i, j));
        		ice ++;
        		
        		while(!q.isEmpty()) {
        			node now = q.poll();
        			for(int k=0;k<4;k++) {
        				int nowx = now.x+dx[k];
        				int nowy = now.y+dy[k];
        				
        				if(0>nowx||0>nowy||n<=nowx||m<=nowy) continue;
        				if(v[nowx][nowy]) continue;
        				if(map[nowx][nowy]==0) continue;
        				
        				v[nowx][nowy] = true;
        				q.add(new node(nowx, nowy));
        			}
        		}
        		
        	}
        }
        
        if(ice >=2) {
        	// 만약 시작부터 빙산이 두 덩이 이상이면 출력 후 종료
        	System.out.println("0");
        	System.exit(0);
        }
        
        int time = 0;
        
        while(true) {
        	time ++;
        	
        	
        	Queue<node> tmp = new LinkedList<node>();
        	// 없어질 빙하의 개수를 담는 큐
        	
        	for(int i=1;i<n-1;i++) {
        		for(int j=1;j<m-1;j++) {
        			if(map[i][j] <= 0) continue;
        			
        			int cnt = 0;
        			// 인접 4칸의 0의 개수를 세는 변수
        			
        			for(int k=0;k<4;k++) {
        				int nowx = i+dx[k];
        				int nowy = j+dy[k];
        				if(0>nowx||0>nowy||n<=nowx||m<=nowy) continue;
        				if(map[nowx][nowy] <= 0) cnt ++;
        			}
        			
        			tmp.add(new node(i, j, cnt));
        		}
        	}
        	
        	// 미리 기존 배열에서 빼버리면 후에 뒷부분 0의 정확한 갯수를 구하기 어려우므로 후에 빼준다.
        	while(!tmp.isEmpty()) {
        		node temp = tmp.poll();
        		
        		map[temp.x][temp.y] -= temp.cnt;
        	}
        	
        	
        	// 빙산이 나눠졌는지 확인
        	boolean c = false; //빙산이 하나라도 있는지 체크하는 변수
        	q = new LinkedList<node>();
        	v = new boolean[n][m];
        	ice = 0;
        	for(int i=1;i<n-1;i++) {
            	for(int j=1;j<m-1;j++) {
            		if(v[i][j]) continue;
            		// 방문했으면 넘어가기 !
            		if(map[i][j]<=0) continue;
            		// 빙산이 아니라면 넘어가기 !
            		
            		// 방문되지 않은 빙하라면 큐에 넣고 bfs를 돌리자
            		c = true;
            		q.add(new node(i, j));
            		ice ++;
            		
            		while(!q.isEmpty()) {
            			node now = q.poll();
            			for(int k=0;k<4;k++) {
            				int nowx = now.x+dx[k];
            				int nowy = now.y+dy[k];
            				
            				if(0>nowx||0>nowy||n<=nowx||m<=nowy) continue;
            				if(v[nowx][nowy]) continue;
            				if(map[nowx][nowy]<=0) continue;
            				
            				v[nowx][nowy] = true;
            				q.add(new node(nowx, nowy));
            			}
            		}
            	}
            }
        	
//        	for(int i=0;i<n;i++) {
//        		for(int j=0;j<m;j++) {
//        			System.out.print(map[i][j]+" ");
//        		}
//        		System.out.println();
//        	}
        	// 빙산이 나눠졌다면
        	if(ice>=2) {
        		System.out.println(time);
        		System.exit(0);
        	}
        	
        	// 빙산이 다 녹았다면
        	if(!c) {
        		System.out.println("0");
        		System.exit(0);
        	}
        }
        
	}
}

class node{
	int x,y,cnt;

	
	public node(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}


	public node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
