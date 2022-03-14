import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {
	private final static int CMD_INIT = 1;
	private final static int CMD_ALLOCATE = 2;
	private final static int CMD_RELEASE = 3;

	private final static UserSolution usersolution = new UserSolution();

	private static boolean run(BufferedReader br) throws Exception {
		int q = Integer.parseInt(br.readLine());

		int n, addr, size;
		int cmd, ans, ret = 0;
		boolean okay = false;

		for (int i = 0; i < q; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
				case CMD_INIT:
					n = Integer.parseInt(st.nextToken());
					usersolution.init(n);
					okay = true;
					break;
				case CMD_ALLOCATE:
					size = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					ret = usersolution.allocate(size);
					if (ret != ans)
						okay = false;
					break;
				case CMD_RELEASE:
					addr = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					ret = usersolution.release(addr);
					if (ret != ans)
						okay = false;
					break;
				default:
					okay = false;
					break;
			}
		}
		return okay;
	}

	public static void main(String[] args) throws Exception {
		int TC, MARK;

		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}

class UserSolution {
	Comparator<Memory> comparator = new Comparator<Memory>() {
		
		@Override
		public int compare(Memory o1, Memory o2) {
			if(o2.size == o1.size) {
				return o1.start - o2.start;
			}else {
				return o1.size-o2.size;
			}
		}
	};
	
	static int N;
	TreeSet<Memory> memSpace;
	HashMap<Integer, Memory> memMap;
	
	public void init(int N) {
		this.N = N;
		memSpace = new TreeSet<>(comparator);
		memMap = new HashMap<>();
		Memory mem = new Memory(0, N-1, N);
		memSpace.add(mem);
		createMemory(mem);
		//memMap[0] = mem, memMap[n-1] = mem 이 들어가있는 상태.
	}

	void createMemory(Memory mem) {
		memMap.put(mem.start, mem);
		memMap.put(mem.end, mem);
	}

	void removeMemory(Memory empty) {
		if(empty!=null) {
			memSpace.remove(empty);
			memMap.remove(empty.start);
			memMap.remove(empty.end);
		}
	}
	
	public int allocate(int mSize) {
		int result = -1;
		Memory alloc = new Memory(-1, 0, mSize);
		Memory empty = null;
		empty = memSpace.higher(alloc);
		// -1보다 더 큰 곳에 할당 ! ! !! 메모리사이즈로 비교해줬기 때문에 그것보다 큰 게 들어옴 ! ! !!
		removeMemory(empty);
		// 할당된 비어있던 공간 삭제
		if( empty != null ) {
			Memory newAlloc = new Memory(empty.start, empty.start+mSize-1, mSize);
			newAlloc.isEmpty = false;
			createMemory(newAlloc);
			result = newAlloc.start;
			if (empty.size > mSize) {
				Memory newEmpty = new Memory(empty.start+mSize, empty.end, empty.size-mSize);
				memSpace.add(newEmpty);
				createMemory(newEmpty);
				// 할당되고 남은공간 할당해주기.
			}
		}
		return result;
	}

	public int release(int mAddr) {
		int res = -1;
		Memory empty = memMap.get(mAddr);
		// mAddr 로 시작하는 메모리공간 정보 얻어오기
		
		if(empty != null && !empty.isEmpty && empty.start == mAddr) {
			Memory newEmpty = new Memory(empty.start, empty.end, empty.size);
			res = newEmpty.size;
			removeMemory(newEmpty);
			Memory fMem = memMap.get(newEmpty.start-1);
			if(fMem != null && fMem.isEmpty) {
				removeMemory(fMem);
				newEmpty.updateValue(fMem.start, newEmpty.end, fMem.size+newEmpty.size);
			}
			
			Memory eMem = memMap.get(newEmpty.end+1);
			if(eMem!=null && eMem.isEmpty) {
				removeMemory(eMem);
				newEmpty.updateValue(newEmpty.start, eMem.end, eMem.size+newEmpty.size);
			}
			memSpace.add(newEmpty);
			createMemory(newEmpty);
		}
		return res;
	}
}

class Memory {
	int start, end, size;
	boolean isEmpty;
	public Memory(int start, int end, int size) {
		super();
		this.start = start;
		this.end = end;
		this.size = size;
		isEmpty = true;
	}
	void updateValue(int start, int end, int size) {
		this.start = start;
		this.end = end;
		this.size = size;
	}
}
