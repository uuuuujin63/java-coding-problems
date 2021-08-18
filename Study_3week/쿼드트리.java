import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] image;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		image = new char[n][n];
		for(int i=0;i<n;i++) {
			image[i] = br.readLine().toCharArray();
		}
		if(n == 1) {
			System.out.println("("+image[0][0]+")");
			System.exit(0);
		}
		
		image_zip(0, 0, n);
		System.out.println(sb);
	}
	public static boolean check(int x, int y, int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(image[i][j]!=image[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void image_zip(int x, int y, int size) {
		if(check(x,y,size)) {
			sb.append(image[x][y]);
			return;
		}
		
		size = size/2;
		sb.append("(");
		image_zip(x, y, size);
		image_zip(x, y+size, size);
		image_zip(x+size, y, size);
		image_zip(x+size, y+size, size);
		sb.append(")");
	}
}
