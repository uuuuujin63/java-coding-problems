import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int res = 0;
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());//가로
		int x = Integer.parseInt(st.nextToken());//세로
		
		int n = Integer.parseInt(br.readLine());
		int[][] shop = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			shop[i][0] = Integer.parseInt(st.nextToken());
			shop[i][1] = Integer.parseInt(st.nextToken());
			if(shop[i][0] == 3) shop[i][0] = 2;
			else if(shop[i][0] == 2) shop[i][0] = 3;
		}
		st = new StringTokenizer(br.readLine());
		int d_d = Integer.parseInt(st.nextToken());
		int d_block = Integer.parseInt(st.nextToken());
		if(d_d == 3) d_d = 2;
		else if (d_d == 2) d_d = 3;	
		for(int[] s:shop) {
			int d = s[0];
			int block = s[1];
			if(d == d_d) {
				res+=Math.abs(block-d_block);
			}
			else if(Math.abs(d-d_d)==2) { //맞은편에 있다면,
				if(d+d_d==4) {
					res += Math.min(block+d_block, (y-block)+(y-d_block));
					res += x;
				}else {
					res += Math.min(block+d_block, (x-block)+(x-d_block));
					res += y;
				}
			}else {
				if(d+d_d == 3) {
					res+=block+d_block;
				}else if(d+d_d==7) { //위치에따라서 3-4일때
					if(d==3&&d_d==4) {
						res+=(x-block)+(y-d_block);
					}else {
						res+=(x-d_block)+(y-block);
					}
				}else if(d==2&&d_d==3) {
					res+=(x-block)+(d_block);
				}else if(d==3&&d_d==2) {
					res+=block+(x-d_block);
				}else if(d==1&&d_d==4) {
					res+=(y-block)+d_block;
				}else if(d==4&&d_d==1) {
					res+=block+(y-d_block);
				}
			}
		}
		System.out.println(res);
		
	}

}
