//2941번

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException   {
		
		String[] alph = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		for (String s:alph) {
			if(word.contains(s)) word = word.replaceAll(s, " ");
		}
		
		System.out.println(word.length());
	}
}
