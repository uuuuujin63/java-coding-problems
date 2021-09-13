import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		//k : 바이러스 종류
		
		int[][] info = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				info[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		if(info[x][y]!=0) {
			//만약 이미 바이러스가 있다면 그대로 출력하고 종료.
			System.out.println(info[x][y]);
			System.exit(0);
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for(int t=0;t<s;t++) {
			for(int kk=1;kk<=k;kk++) {
				Queue<Integer> xx = new LinkedList<Integer>();
				Queue<Integer> yy = new LinkedList<Integer>();
				//큐에 넣은 다음에 마지막에 한 번에 처리 해준다.
				//한번에 처리하지 않으면 아래에서 한번씩 더 바이러스가 퍼지는 논리오류 발생
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(info[i][j]==kk) {
							//만약 현재 퍼질 바이러스와 같은 종류인 칸에 왔다면,
							for(int d=0;d<4;d++) {
								int nowi = i+dx[d];
								int nowj = j+dy[d];
								if(nowi<0||nowi>=n||nowj<0||nowj>=n) continue;
								//범위에서 벗어나면 컨티뉴
								
								if(info[nowi][nowj]==0) {
									xx.add(nowi);
									yy.add(nowj);
								}
							}
						}
					}
				}
				while(!xx.isEmpty()) {
					info[xx.poll()][yy.poll()] = kk;
				}
			}
			if(info[x][y]!=0) {
				//만약 이미 바이러스가 있다면 그대로 출력하고 종료.
				System.out.println(info[x][y]);
				System.exit(0);
			}
		}
		System.out.println(info[x][y]);
	}
}

