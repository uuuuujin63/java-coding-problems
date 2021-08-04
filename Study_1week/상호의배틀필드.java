package 상호의배틀필드;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			
			int jcx = 0;
			int jcy = 0;
			for(int i=0;i<h;i++) {
				String tmp = br.readLine();
				if(tmp.contains("<")||tmp.contains(">")||tmp.contains("^")||tmp.contains("v")) {
					jcx = i;
					jcy = Math.max(tmp.indexOf("<"), tmp.indexOf(">"));
					jcy = Math.max(jcy, tmp.indexOf("^"));
					jcy = Math.max(jcy, tmp.indexOf("v"));	
				}
				map[i] = tmp.toCharArray();
			}
			int n = Integer.parseInt(br.readLine());
			char[] inps = br.readLine().toCharArray();
			
			int dx = 0;
			int dy = 0;
			for(char inp : inps) {
//				for(int i=0;i<h;i++) {
//					for(int j=0;j<w;j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("\n"+inp);
				if (inp == 'U') {
					map[jcx][jcy] = '^';
					if (0<=jcx-1&&map[jcx-1][jcy]=='.') {
						map[jcx-1][jcy]='^';
						map[jcx][jcy] ='.';
						jcx = jcx-1;
					}
				}else if (inp == 'D') {
					map[jcx][jcy] = 'v';
					if (jcx+1<h&&map[jcx+1][jcy]=='.') {
						map[jcx+1][jcy]='v';
						map[jcx][jcy] ='.';
						jcx = jcx+1;
					}
				}else if (inp == 'L') {
					map[jcx][jcy] = '<';
					if (0<=jcy-1&&map[jcx][jcy-1]=='.') {
						map[jcx][jcy-1]='<';
						map[jcx][jcy] ='.';
						jcy = jcy-1;
					}
				}else if (inp == 'R') {
					map[jcx][jcy] = '>';
					if (jcy+1<w&&map[jcx][jcy+1]=='.') {
						map[jcx][jcy+1]='>';
						map[jcx][jcy] ='.';
						jcy = jcy+1;
					}
				}else if (inp == 'S') {
					if(map[jcx][jcy]=='>') {
						dx = 0;
						dy = 1;
					}else if(map[jcx][jcy]=='<') {
						dx = 0;
						dy = -1;
					}else if(map[jcx][jcy]=='v') {
						dx = 1;
						dy = 0;
					}else if (map[jcx][jcy]=='^') {
						dx = -1;
						dy = 0;
					}
					if((0<=jcx+dx&&jcx+dx<h)&&(0<=jcy+dy&&jcy+dy<w)) {
						int nowx = jcx+dx;
						int nowy = jcy+dy;
						if(map[nowx][nowy]=='.'||map[nowx][nowy]=='-') {
							while(((0<=nowx+dx&&nowx+dx<h)&&(0<=nowy+dy&&nowy+dy<w))&&(map[nowx+dx][nowy+dy]=='.'||map[nowx+dx][nowy+dy]=='-')) {
								nowx += dx;
								nowy += dy;
							}
							if (((0<=nowx+dx&&nowx+dx<h)&&(0<=nowy+dy&&nowy+dy<w))&&(map[nowx+dx][nowy+dy]=='*')) {
								map[nowx+dx][nowy+dy] = '.';
							}
						}
						else if((map[nowx][nowy]=='*')) {
							map[nowx][nowy] = '.';
						}
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
