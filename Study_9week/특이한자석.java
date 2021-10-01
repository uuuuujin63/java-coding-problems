
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static LinkedList<Integer>[] cq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int[] score = { 1, 2, 4, 8 };
		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			cq = new LinkedList[4];
			for (int i = 0; i < 4; i++) {
				cq[i] = new LinkedList<Integer>();
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					int a = Integer.parseInt(st.nextToken());
					cq[i].add(a);
				}
			}
			int[][] d = new int[k][2];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				d[i][0] = Integer.parseInt(st.nextToken()) - 1;
				d[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int tt = 0; tt < k; tt++) {
				int nowd = d[tt][1]; //nowd:처음 돌리는 곳의 회전 방향이 담기는 변수
				int start = d[tt][0]; //start:처음 돌리는 곳의 인덱스가 담기는 변수
				boolean[] ro_c = new boolean[4];
				//아무것도 회전시키기 전에 돌릴지 여부를 판단해주는 배열
				ro_c[start] = true;
				//처음 돌리는 곳은 무조건 돌리기 때문에 true
				
				//처음 돌리는 곳의 왼편 회전여부 검사
				for(int i=start-1;i>=0;i--) {
					if (cq[i].get(2) != cq[i+1].get(6))
						ro_c[i] = true;
					else break;
				}
				
				//처음 돌리는 곳의 오른편 회전 여부 검사
				for(int i=start+1;i<4;i++) {
					if (cq[i-1].get(2) != cq[i].get(6))
						ro_c[i] = true;
					else break;
				}
				
				//처음꺼 돌려주고
				rota(start, nowd);
				
				//왼편부터 돌리기
				for(int i=start-1;i>=0;i--) {
					if(ro_c[i]) {
						//방향은 계속 바꿔가면서 돌려준다.
						nowd = nowd==1?-1:1;
						rota(i, nowd);
					}
					else break;
				}
				
				//오염된 nowd를 다시 원래 값으로 초기화 시킨 후 오른쪽 방향 진행
				nowd = d[tt][1];
				for(int i=start+1;i<4;i++) {
					if(ro_c[i]) {
						nowd = nowd==1?-1:1;
						rota(i, nowd);
					}
					else break;
				}
			}
			int res = 0;
			for (int i = 0; i < 4; i++) {
				if (cq[i].get(0) == 1) {
					res += score[i];
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	public static void rota(int idx, int di) {
		if (di == 1) { // 시계방향
			int tmp = cq[idx].get(7);
			cq[idx].remove(7);
			cq[idx].add(0, tmp);
			// 한칸 돌리기
		} else { // 반시계방향 : 맨앞에꺼 뒤로 가져오기
			int tmp = cq[idx].get(0);
			cq[idx].remove(0);
			cq[idx].add(tmp);
			// 한칸 돌리기
		}
	}

}
