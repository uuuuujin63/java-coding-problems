// 16918 봄버맨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        for(int i=0;i<r;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<c;j++) {
        		if(tmp.charAt(j)=='.') {
        			map[i][j] = 0;
        		}else {
        			map[i][j] = 1;
        		}
        	}
        }
        
        int time = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(true) {
        	if(time>=n) break;
        	// n=1 일 때를 고려
        	
        	time ++;
        	// 1. 폭탄 설치
        	for(int i=0;i<r;i++) {
        		for (int j=0;j<c;j++) {
        			if (map[i][j]==0) {
        				map[i][j] = 2;
        			}
        		}
        	}
        	
        	if(time>=n) break;
        	// n초 만큼 시간이 흘렀는지 검사
        	
        	time++;
        	// 2. 폭탄 터트리기
        	for(int i=0;i<r;i++) {
        		for(int j=0;j<c;j++) {
        			if(map[i][j]==1) {
        				map[i][j] = 0;
        				// 2-(1). 주변 폭탄 터트리기
        				for(int k=0;k<4;k++) {
        					int nowx = dx[k]+i, nowy = dy[k]+j;
        					if(0>nowx||0>nowy||r<=nowx||c<=nowy) continue;
        					if(nowx>=i && nowy>=j && map[nowx][nowy]==1) continue;
        					map[nowx][nowy] = 0;
        				}
        			}else if(map[i][j]==2) {
        				map[i][j]--;
        			}
        		}
        	}
        	if(time>=n) break;
        	// n초 만큼 시간이 흘렀는지 검사
        }
        
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        		if(map[i][j]==0) {
        			sb.append(".");
        		}else {
        			sb.append("O");
        		}
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    
}
