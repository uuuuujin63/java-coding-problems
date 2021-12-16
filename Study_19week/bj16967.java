// 백준 16967 배열 복원하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] a = new int[h][w];
        int[][] b = new int[h+x][w+y];
        
        for(int i=0;i<h+x;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<w+y;j++) {
        		if((i<x&&j<w)||(i<h&&j<y)) {
        			a[i][j] = Integer.parseInt(st.nextToken());
        			b[i][j] = a[i][j];
        		}else {
        			b[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        }
        
        for(int i=x;i<h;i++) {
        	for(int j=y;j<w;j++) {
        		a[i][j] = b[i][j]-a[i-x][j-y];
        	}
        }
        
        for(int i=0;i<h;i++) {
        	for(int j=0;j<w;j++) {
        		System.out.print(a[i][j]+" ");
        	}
        	System.out.println();
        }
	}
}
