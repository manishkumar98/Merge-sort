

public class MinHeap{ 
	private int[] Heap; 
	private int size; 
	private int maxsize; 

	private static final int FRONT = 1; 

	public MinHeap(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MIN_VALUE; 
	} 

	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

		private void swap(int fpos, int spos) 
	{ 
		int temp; 
		temp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = temp; 
	} 
 
	private void minHeapify(int pos) 
	{ 

		if (!isLeaf(pos)) { 
			if (Heap[pos] > Heap[leftChild(pos)] 
				|| Heap[pos] > Heap[rightChild(pos)]) { 

				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				} 

				else { 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 

	public void insert(int element) 
	{ 
		if (size >= maxsize) { 
			return; 
		} 
		Heap[++size] = element; 
		int current = size; 

		while (Heap[current] < Heap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] 
							+ " LEFT CHILD : " + Heap[2 * i] 
							+ " RIGHT CHILD :" + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	public void minHeap() 
	{ 
		for (int pos = (size / 2); pos >= 1; pos--) { 
			minHeapify(pos); 
		} 
	} 

	public int remove() 
	{ 
		int popped = Heap[FRONT]; 
		Heap[FRONT] = Heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	} 

	public static void main(String[] arg) 
	{ 
		System.out.println("The Min Heap is "); 
		MinHeap minheap = new MinHeap(15); 
		minheap.insert(5); 
		minheap.insert(3); 
		minheap.insert(17); 
		minheap.insert(10); 
		minheap.insert(84); 
		minheap.insert(19); 
		minheap.insert(6); 
		minheap.insert(22); 
		minheap.insert(9); 
		minheap.minHeap(); 

		minheap.print(); 
		System.out.println("The Min val is " + minheap.remove()); 
	} 
} 
