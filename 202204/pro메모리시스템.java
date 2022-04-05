import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

class UserSolution {
	static Comparator<Memory> mSort = new Comparator<Memory>() {

		@Override
		public int compare(Memory o1, Memory o2) {
			if (o1.size == o2.size) {
				return o1.start - o2.start;
			}
			return o1.size - o2.size;
		}
	};
	static HashMap<Integer, Memory> using = new HashMap<Integer, Memory>();
	static HashMap<Integer, Memory> e_start = new HashMap<Integer, Memory>();
	static HashMap<Integer, Memory> e_end = new HashMap<Integer, Memory>();
	static TreeSet<Memory> empty;
	static int N;

	public void init(int N) {
		using.clear();
		empty = new TreeSet<Memory>(mSort);
		e_start.clear();
		e_end.clear();
		this.N = N;
		// n 크기만큼의 공간할당
		Memory m = new Memory(0, N - 1, N);
		e_start.put(0, m);
		e_end.put(N - 1, m);
		empty.add(m);
	}

	public int allocate(int mSize) {
		if (empty.tailSet(new Memory(0, 0, mSize)).size() == 0) {
			return -1;
		}
		Memory m = empty.tailSet(new Memory(0, 0, mSize)).first();

		Memory newUsing = new Memory(m.start, m.start + mSize - 1, mSize);
		Memory newEmpty = new Memory(m.start + mSize, m.end, m.end - m.start - mSize + 1);

		using.put(newUsing.start, newUsing);

		e_start.remove(m.start);
		e_end.remove(m.end);
		e_start.put(newEmpty.start, newEmpty);
		e_end.put(newEmpty.end, newEmpty);

		empty.remove(m);
		empty.add(newEmpty);

//		System.out.println(using.toString());
//		System.out.println(m.start);
		return m.start;
	}

	public int release(int mAddr) {
		Memory m = using.get(mAddr);
		
		if (m == null) {
			return -1;
		}
		// 사용중인 메모리에서 제거
		using.remove(m.start);

		Memory left = e_end.get(m.start - 1);
		Memory right = e_start.get(m.end + 1);

		int start = m.start;
		int end = m.end;
		int size = m.size;

		if (left != null) {
			// 왼쪽공간 합쳐주기
			size += left.size;
			start = left.start;
			e_start.remove(left.start);
			e_end.remove(left.end);
			empty.remove(left);
		}

		if (right != null) {
			// 오른쪽공간 합쳐주기
			size += right.size;
			end = right.end;
			e_start.remove(right.start);
			e_end.remove(right.end);
			empty.remove(right);
		}

		// 빈공간 할당
		empty.add(new Memory(start, end, size));
		e_start.put(start, new Memory(start, end, size));
		e_end.put(end, new Memory(start, end, size));
//		System.out.println(using.toString());
//		System.out.println(m.size);
		return m.size;
	}
}

class Memory {
	int start, end, size;

	public Memory(int start, int end, int size) {
		super();
		this.start = start;
		this.end = end;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Memory [start=" + start + ", end=" + end + ", size=" + size + "]";
	}

}
