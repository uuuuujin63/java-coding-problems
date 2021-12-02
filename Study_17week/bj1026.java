import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int n = Integer.parseInt(br.readLine());
      int[] a_arr = new int[n];
      int[] b_arr = new int[n];
      
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<n;i++) {
    	  a_arr[i] = Integer.parseInt(st.nextToken());
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<n;i++) {
    	  b_arr[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(a_arr);
      Arrays.sort(b_arr);
      
      int res = 0;
      
      for(int i=0;i<n;i++) {
    	  res += (a_arr[i]*b_arr[n-i-1]);
      }
      
      System.out.println(res);
   }

}
