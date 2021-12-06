import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] w = new int[n];
      
      for(int i=0;i<n;i++) {
    	  w[i] = Integer.parseInt(br.readLine());
      }
      
      Arrays.sort(w);
      
      long res = 0;
      for(int i=n-1; i>=0; i--) {
    	  w[i] = w[i]*(n-i);
    	  if(res<w[i]) res = w[i];
      }
      System.out.println(res);
   }

}
