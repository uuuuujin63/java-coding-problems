class Solution {
    public int solution(String s) {
        int answer = 1000;
        int n = s.length();
        StringBuilder sb;
        if(n == 1) return 1;
        for(int i=1;i<=n/2;i++) {
        	sb = new StringBuilder();
        	String tmp=null;
        	int cnt = 1;
        	StringBuilder ressb = new StringBuilder();
        	for(int j=0;j<=n;j++) {
        		if(j<n) sb.append(s.charAt(j));
        		if(j+1 == i) {
        			tmp = sb.toString();
        			sb = new StringBuilder();
        		}
        		else if(j%i == i-1 || j == n) { //비교요소 끝
        			if(tmp.equals(sb.toString())) {
        				sb = new StringBuilder();
        				cnt++;
        			}else {
        				if(cnt == 1) {
        					ressb.append(tmp);
        					
        				}else {
        					ressb.append(cnt).append(tmp);
        					cnt = 1;
        				}
        				tmp = sb.toString();
        				sb = new StringBuilder();
        			}
        		}
        	}
        	if(tmp.length()!=0) {
    			ressb.append(tmp);
    		}
        	answer = Math.min(answer, ressb.length());
        	
        }
        return answer;
    }
}
