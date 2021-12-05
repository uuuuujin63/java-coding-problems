import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      int t = Integer.parseInt(br.readLine());
      
      for(int tt=0;tt<t;tt++) {
    	  st = new StringTokenizer(br.readLine());
    	  int m = Integer.parseInt(st.nextToken());
    	  int n = Integer.parseInt(st.nextToken());
    	  int k = Integer.parseInt(st.nextToken());
    	  int[][] map= new int[n][m];
    	  Queue<node> b_q = new LinkedList<node>();
    	  for(int i=0;i<k;i++) {
    		  st = new StringTokenizer(br.readLine());
        	  int x = Integer.parseInt(st.nextToken());
        	  int y = Integer.parseInt(st.nextToken());
        	  map[y][x] = 1;
        	  b_q.add(new node(y, x)); //배추 심어져있는 곳 큐로 넣기
    	  }
    	  int res = 0;
    	  int[] dx = {-1, 1, 0, 0};
    	  int[] dy = {0, 0, -1, 1};
    	  while(!b_q.isEmpty()) { // 배추가 심어져있는 곳 검사하기.
    		  node tmp = b_q.poll();
    		  Queue<node> q = new LinkedList<node>();
    		  if(map[tmp.x][tmp.y]==0) continue;
              // 연결되어있어서 이미 0으로 바뀐 곳이라면 더 이상 알아보지 않아도 되므로 컨티뉴
    		  q.add(new node(tmp.x, tmp.y));
              // 위에서 컨티뉴 되지 않았음 -> 아직 1인 곳이므로 bfs를 돌려 인접한 곳 모두 일반 땅으로 바꿔준다.
              // 즉 방문처리 해주기 위한 큐
    		  res++; // 지렁이 카운트
    		  map[tmp.x][tmp.y] = 0; // 이곳이 방문처리 하는 곳.
    		  while(!q.isEmpty()) { 
    			  // tmp와 연결되어있는 곳들은 벌레 한마리면 충분하니까 bfs로 0으로 바꿔준다.
    			  node now = q.poll();
    			  for(int i=0;i<4;i++) {
    				  int nowx = now.x+dx[i];
    				  int nowy = now.y+dy[i];
    				  if(0>nowx||0>nowy||n<=nowx||m<=nowy) {
    					  continue;
    				  }
    				  if(map[nowx][nowy] == 1) {
    					  map[nowx][nowy] = 0;
    					  q.add(new node(nowx, nowy));
    				  }
    			  }
    		  }
    	  }
    	  sb.append(res).append("\n");
      }
      System.out.println(sb);
   }

}
class node{
	int x,y;

	public node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
