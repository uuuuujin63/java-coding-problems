import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	static public int[] solution(int rows, int columns, int[][] queries) {
        Queue<Integer> ans_q = new LinkedList<Integer>();
        int[][] map = new int[rows][columns];
        for(int i=0;i<rows;i++) {
        	for(int j=1;j<=columns;j++){
        		map[i][j-1] = i*columns+j;
        	}
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        
        for(int[] q : queries) {
        	int min = rows*columns;
        	int x1 = q[0]-1;
        	int y1 = q[1]-1;
        	int x2 = q[2]-1;
        	int y2 = q[3]-1;
        	//한눈에 알 수 있도록 변수를 지정해서 표현
        	int[][] limit = {{x1,y1},{x2,y1},{x2,y2},{x1,y2}};
        	int x = x1;
        	int y = y2;
        	int tmp = map[x][y];
        	for(int i=0;i<4;i++) {
        		while(true) {
        			int nowx = x+dx[i];
        			int nowy = y+dy[i];
        			if(0>nowx||0>nowy||rows<=nowx||columns<=nowy) continue;
        			min = Math.min(map[x][y], min);
        			map[x][y] = map[nowx][nowy];
        			x = nowx;
        			y = nowy;
        			if(nowx==limit[i][0]&&nowy==limit[i][1]) {
        				break;
        			}
        		}
        	}
        	map[x1+1][y2] = tmp;
        	ans_q.add(min);
        	for(int i=0;i<rows;i++) {
        		for(int j=0;j<columns;j++) {
        			System.out.print(map[i][j]+" ");
        		}
        		System.out.println();
        	}
        }
        int[] ans = new int[ans_q.size()];
        int i=0;
        while(!ans_q.isEmpty()) {
        	ans[i++] = ans_q.poll();
        }
        return ans;
    }
