import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static Card[] selected, cards;
	static int res;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			cards = new Card[7];
			for (int i = 0; i < 7; i++) {
				st = new StringTokenizer(br.readLine());
				char m = st.nextToken().charAt(0);
				String tmpn = st.nextToken();
				int n = Integer.parseInt(tmpn);
				if (tmpn.endsWith("Ace")) {
					n = 1;
				} else if (tmpn.endsWith("Jack")) {
					n = 11;
				} else if (tmpn.endsWith("Queen")) {
					n = 12;
				} else if (tmpn.endsWith("King")) {
					n = 13;
				} else if (tmpn.endsWith("14")) {
					n = 1;
				}
				cards[i] = new Card(m, n);
			}

			selected = new Card[5];
			res = 0;
			combi(0, 0);

			String[] resStr = { "Top", "1 Pair", "2 Pair", "Triple", "Straight", "Flush", "Full House", "4 Card",
					"Straight Flush" };
			sb.append("#").append(test_case).append(" ").append(resStr[res]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static void combi(int cnt, int idx) {
		if (cnt == 5) {
			poker();
			return;
		}

		for (int i = idx; i < 7; i++) {
			selected[cnt] = cards[i];
			combi(cnt + 1, i + 1);
		}
	}

	public static void poker() {
		int[] nCnt = new int[14];
		int[] mCnt = new int[4];

		for (int i = 0; i < 5; i++) {
			if (selected[i].m == 'S')
				mCnt[0]++;
			else if (selected[i].m == 'D')
				mCnt[1]++;
			else if (selected[i].m == 'C')
				mCnt[2]++;
			else if (selected[i].m == 'H')
				mCnt[3]++;

			nCnt[selected[i].n - 1]++;
			if (selected[i].n == 1) {
				nCnt[13]++;
			}

		}
		int Pair = 0;
		int Triple = 0;
		int Card4 = 0;
		boolean isStraight = false;
		// 연속되는지 확인
		for (int i = 0; i < 10; i++) {
			if (nCnt[i] == 0)
				continue;
			boolean c = true;
			for (int j = i + 1; j < i + 5; j++) {
				if (nCnt[j] == 0) {
					c = false;
					break;
				}
			}
			if (c) {
				isStraight = true;
				break;
			}
			if (nCnt[i] == 2)
				Pair++;
			else if (nCnt[i] == 3)
				Triple++;
			else if(nCnt[i]==4)
				Card4++;
		}

		for (int i = 10; i < 13; i++) {
			if (nCnt[i] == 2)
				Pair++;
			else if (nCnt[i] == 3)
				Triple++;
			else if(nCnt[i]==4)
				Card4++;
		}

		if (isStraight) {
			// 4. Straight
			res = res < 4 ? 4 : res;
		}

		if (mCnt[0] == 5 || mCnt[1] == 5 || mCnt[2] == 5 || mCnt[3] == 5) {
			if (isStraight) {
				// 8. Straight Flush
				res = 8;
				return;
			}
			// 5. Flush
			res = res < 5 ? 5 : res;
		}

		if (Pair > 0 && Triple > 0) {
			// 6. Full House
			res = res < 6 ? 6 : res;
		} else if (Pair == 2) {
			// 2. 2 Pair
			res = res < 2 ? 2 : res;
		} else if (Pair == 1) {
			// 1. 1 Pair
			res = res < 1 ? 1 : res;
		} else if (Triple == 1) {
			// 3. Triple
			res = res < 3 ? 3 : res;
		} else if(Card4 == 1) {
			// 7. 4 card
			res = res< 7? 7:res;
		}
	}
}

class Card {
	char m;
	int n;

	public Card(char m, int n) {
		super();
		this.m = m;
		this.n = n;
	}
}
