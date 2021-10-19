import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, pown, res;
	static int[] info;
	static int[][] seat;
	static ArrayList<Integer>[] infolist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		seat = new int[n][n];
		pown = (int) Math.pow(n, 2);
		info = new int[pown];
		infolist = new ArrayList[pown+1];
		for(int i=0;i<pown+1;i++) {
			infolist[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<pown;i++) {
			st = new StringTokenizer(br.readLine());
			info[i] = Integer.parseInt(st.nextToken());
			for(int j=0;j<4;j++) {
				infolist[info[i]].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		outer:for(int k=0;k<pown;k++) {
			PriorityQueue<node> q = new PriorityQueue<>();
			
			if(k==0) {
				seat[1][1] = info[k];
				continue;
				// 첫번째 사람은 무조건 !
			}
			
			if(k==pown-1) {
				// 마지막 학생은 남은자리 하나에 넣기
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(seat[i][j]==0) {
							seat[i][j] = info[k];
							break outer;
						}
					}
				}
			}
			// k인덱스를 가진 학생의 자리탐색 시작
			node nowk = count_like(k);
			
			seat[nowk.x][nowk.y] = info[k];
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(seat[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		count_score();
		System.out.println(res);
	}
	
	public static node count_like(int k) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		PriorityQueue<node> q = new PriorityQueue<>();
		
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				if(seat[x][y]!=0) continue;
				// 이미 정해진 자리면 검사하지 않아도 된다.
				int cnt = 0;
				for(int i=0;i<4;i++) {
					int nowx = x+dx[i], nowy = y+dy[i];
					if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue;
					if(infolist[info[k]].contains(seat[nowx][nowy])) cnt++;
				}
				q.add(new node(x,y,cnt));
			}
		}
		
		int cnt = 1;
//		if(info[k]==7) {
//			System.out.println(q.toString()+cnt);
//		}
		PriorityQueue<node> rq = new PriorityQueue<>();
		// 1번을 만족하는 칸이 여러개이면 다음 함수로 넘겨주기 전 만족하는 칸들에 대한 정보를 담아서 리턴한다.
		rq.add(q.poll());
		int likecount = rq.peek().near;
		while(!q.isEmpty()) {
			node p_node = q.poll();
			if(p_node.near==likecount) {
				// 여러개이면 rq에 넣는다.
				cnt ++;
				rq.add(p_node);
			} else {
				// 아니면 종료
				break;
			}
		}
//		if(info[k]==7) {
//			System.out.println(rq.toString()+cnt);
//		}
		if(cnt==1) {
			// 자리가 바로 나오면 리턴
			return rq.poll();
		} else {
			// 바로 자리가 나오지 않으면 2번으로 넘어간다.
			return count_empty(rq, k);
		}
	}
	
	public static node count_empty(PriorityQueue<node> q, int k) {
		PriorityQueue<node> rq = new PriorityQueue<>();
		// 학생이 놓일 후보 자리값과 인접한 칸 중 비어있는 칸의 카운트를 넣는 우선순위 큐
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			node now_n = q.poll();
			int cnt = 0;
			for(int i=0;i<4;i++) {
				int nowx=now_n.x+dx[i], nowy=now_n.y+dy[i];
				if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue;
				if(seat[nowx][nowy]==0) cnt++;
			}
			rq.add(new node(now_n.x, now_n.y, cnt));
		}
//		if(info[k]==7) {
//			System.out.println(rq.toString());
//		}
		return rq.poll();
	}
	
	public static void count_score() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[] score = {0, 1, 10, 100, 1000};
		
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				int cnt = 0;
				for(int i=0;i<4;i++) {
					int nowx = x+dx[i], nowy = y+dy[i];
					if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue;
					if(infolist[seat[x][y]].contains(seat[nowx][nowy])) cnt++;
				}
				res += score[cnt];
			}
		}
	}
}

class node implements Comparable<node>{
	int x,y,near;

	public node(int x, int y, int near) {
		super();
		this.x = x;
		this.y = y;
		this.near = near;
	}

	@Override
	public int compareTo(node o) {
		// TODO Auto-generated method stub
		if(this.near == o.near) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}
		return o.near-this.near;
	}

	@Override
	public String toString() {
		return "node [x=" + x + ", y=" + y + ", near=" + near + "]";
	}
	
}
