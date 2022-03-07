import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Solution {
	static int N;
	static int[] Firstchild, Secondchild;
	static char[] Answer, Alpha;
	
	public static void main(String args[]) throws Exception	{
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		/*
		   10개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		for(int test_case = 1; test_case <= 10; test_case++) {
		/*
			 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 정점의 개수는 N에 저장됩니다.
			 
			 각 정점 번호 i에 대해서 해당하는 정보가 다음 배열 i번째 index에 저장됩니다.
			 해당 정점이 자식을 갖는 경우, Alpha[i]에 해당 연산자가 저장되며 Firstchild[i], Secondchild[i]에 각각 자식 정점의 번호가 저장됩니다.
			 해당 정점이 단말일 경우 해당 위치의 Firstchild,Secondchild의 값은 보장되지 않습니다.
		 */

			N = sc.nextInt();
			Firstchild = new int [101];
			Secondchild = new int [101];
			Alpha = new char[101];
			Answer = new char[101];

			for(int i = 0; i < N; i++) {
				int addr = sc.nextInt();
				String buf = sc.next();
				
				Alpha[addr] = buf.charAt(0);
				
				if(addr*2 <= N) {
					Firstchild[addr] = sc.nextInt();
					if(addr*2 + 1 <= N) {
						Secondchild[addr] = sc.nextInt();
					}
				}
			}

			System.out.print("#" + test_case+" ");
			inOrder(1);
			System.out.println();
		}
	}

	static void inOrder(int idx) {
		if(Firstchild[idx]!=0)
			inOrder(Firstchild[idx]);
		System.out.print(Alpha[idx]);
		if(Secondchild[idx]!=0)
			inOrder(Secondchild[idx]);
	}
}

