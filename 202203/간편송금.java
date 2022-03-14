import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class UserSolution {
    
   private final static int MAX_NAME_LEN = 4 + 1;

	static HashMap<String, User> user = new HashMap<>();
	// user : 유저 이름과 계좌가 담긴다.
	static HashMap<String, HashSet<String>> group = new HashMap<>();
	// group : 회사 이름과 유저 정보(유저이름)들이 담긴다.
	static Account[] mNum;
	// mNum : 계좌번호에 대한 계좌 정보가 담길 배열

	void init() {
		user.clear();
		group.clear();
		mNum = new Account[100001];
		// 1<= mNUM <= 100000
	}

	void openAccount(int mTime, char mName[], char mGroup[], int mNumber, int mAsset) {
		String name = "";
		String groupName = "";

		for (int i = 0; i < MAX_NAME_LEN; i++) {
			if (mName[i] == '\0')
				break;
			name += mName[i];
		}
		for (int i = 0; i < MAX_NAME_LEN; i++) {
			if (mGroup[i] == '\0')
				break;
			groupName += mGroup[i];
		}

		// 계좌정보 넣기
		mNum[mNumber] = new Account(mTime, mAsset, mNumber, groupName, true);
		// user에 넣기
		if (user.get(name) == null) {
			// 처음 계좌 트는 고객이라면
			User u = new User();
			u.account.add(mNumber);
			user.put(name, u);
		} else {
			// 있다면 계좌 추가해주기
			User u = user.get(name);
			u.account.add(mNumber);
			user.put(name, u);
		}

		// group 에 넣기
		if (group.get(groupName) == null) {
			// 처음나온 그룹이라면
			HashSet<String> tmp = new HashSet<>();
			tmp.add(name);
			group.put(groupName, tmp);
		} else {
			HashSet<String> tmp = group.get(groupName);
			tmp.add(name);
			group.put(groupName, tmp);
		}

//		System.out.println("openAccount " + mTime + " " + mNumber);
//		for (int i = 0; i <= 100000; i++) {
//			if (mNum[i] != null)
//				System.out.println(mNum[i].toString());
//		}
	}

	int closeAccount(int mTime, int mNumber) {
		int res = mNum[mNumber].asset;
		mNum[mNumber] = null;
//		System.out.println(res);
		return res;
	}

	int sendByNumber(int mTime, int mNumber, int mReceiveNumber, int mValue) {
//		System.out.println("sendByNumber " + mTime + " " + mNumber + " " + mReceiveNumber + " " + mValue);
		if (mNum[mNumber] == null || mNum[mReceiveNumber] == null || mNum[mNumber].asset < mValue) {
//			System.out.println("-1");
			return -1;
		}

		// 송금하는 사람
		mNum[mNumber].asset -= mValue;
		mNum[mNumber].deposit = false;
		mNum[mNumber].time = mTime;

		// 송금 받는 사람
		mNum[mReceiveNumber].asset += mValue;
		mNum[mReceiveNumber].deposit = true;
		mNum[mReceiveNumber].time = mTime;

//		System.out.println(mNum[mReceiveNumber].asset);
		return mNum[mReceiveNumber].asset;
	}

	int sendByName(int mTime, int mNumber, char mReceiveName[], int mValue) {
		String name = "";
		for (int i = 0; i < MAX_NAME_LEN; i++) {
			if (mReceiveName[i] == '\0')
				break;
			name += mReceiveName[i];
		}
//		System.out.println("sendByName " + mTime + " " + mNumber + " " + name + " " + mValue);
		User u = user.get(name);
		// 고객이 가진 계좌번호들 구하기
		if (u == null || u.account.size() == 0) {
//			System.out.println("-1");
			return -1;
		}

		PriorityQueue<Account> pq = new PriorityQueue<>();

		for (int acc : u.account) {
			if (mNum[acc] == null)
				continue;
			pq.add(mNum[acc]);
		}

		if (pq.size() == 0)
			return -1;
		Account top = pq.poll();
		// 우선순위가 가장 높은 계좌

		if (top == null || mNum[mNumber] == null || mNum[top.number] == null || mNum[mNumber].asset < mValue) {
//			System.out.println("-1");
			return -1;
		}

		mNum[mNumber].asset -= mValue;
		mNum[mNumber].deposit = false;
		mNum[top.number].asset += mValue;
		mNum[top.number].deposit = true;
		mNum[mNumber].time = mTime;
		mNum[top.number].time = mTime;
//
//		for (int i = 0; i <= 100000; i++) {
//			if (mNum[i] != null)
//				System.out.println(mNum[i].toString());
//		}
//		System.out.println(mNum[top.number].asset);
		return mNum[top.number].asset;
	}

	void sendBonus(int mTime, char mGroup[], int mValue) {
		String groupName = "";

		for (int i = 0; i < MAX_NAME_LEN; i++) {
			if (mGroup[i] == '\0')
				break;
			groupName += mGroup[i];
		}
//		System.out.println("sendByName " + mTime + " " + groupName + " " + mValue);
		HashSet<String> tmp = group.get(groupName);
		// tmp에는 해당 회사 계좌를 가진 고객의 이름이 들어감.
		for (String name : tmp) {
			User u = user.get(name);
			PriorityQueue<Account> pq = new PriorityQueue<>();

			for (int acc : u.account) {
				if (mNum[acc] == null)
					continue;
				if (!mNum[acc].g.equals(groupName))
					continue;
				pq.add(mNum[acc]);
			}

			Account top = pq.poll();
			// 우선순위가 가장 높은 계좌
			mNum[top.number].asset += mValue;
			mNum[top.number].deposit = true;
			mNum[top.number].time = mTime;
		}
//		for(int i=0;i<=50;i++) {
//			if(mNum[i]!=null)System.out.println(mNum[i].toString());
//		}
	}
}

class User {
	List<Integer> account = new LinkedList<Integer>();

	public User() {
		super();
	}

	public User(List<Integer> account) {
		super();
		this.account = account;
	}

}

class Account implements Comparable<Account> {
	int time, asset, number;
	String g;
	boolean deposit;
	// 입금인지 출금인지. true면 입금

	public Account(int time, int asset, int number, String g, boolean deposit) {
		super();
		this.time = time;
		this.asset = asset;
		this.number = number;
		this.deposit = deposit;
		this.g = g;
	}

	@Override
	public int compareTo(Account o) {
		if (o.time == this.time) {
			// 잔액 변동시간이 같다면
			if (this.deposit && !o.deposit) {
				return -1;
			} else if (o.deposit && !this.deposit) {
				return 1;
			} else {
				return 0;
			}
		} else if (o.time > this.time)
			return 1;
		return -1;
	}

	@Override
	public String toString() {
		return "Account [time=" + time + ", asset=" + asset + ", number=" + number + ", g=" + g + ", deposit=" + deposit
				+ "]";
	}

}
