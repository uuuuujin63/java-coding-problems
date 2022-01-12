// 패션왕 신해빈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tt=0;tt<t;tt++) {
        	HashMap<String, Integer> info = new HashMap<String, Integer>();
        	int n = Integer.parseInt(br.readLine());
        	for(int i=0;i<n;i++) {
        		String tmp = br.readLine();
        		String[] wear = tmp.split(" "); // 공백으로 분류
        		if(info.containsKey(wear[1])) {
        			// 이미 존재하면 +1만 해줌
        			int value = info.get(wear[1]);
        			info.put(wear[1], value+1);
        		} else {
        			// 존재하지 않으면 2 대입 (경우의 수. 안입을 때, 입을때)
        			info.put(wear[1], 2);
        		}
        	}
        	int sum = 1;
        	for(String key:info.keySet()) {
        		sum *=info.get(key);
        	}
        	sb.append(sum-1).append("\n");
        }
        System.out.println(sb);
	}
}
