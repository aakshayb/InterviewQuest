class Q20_9{
	public static void main(String[] args){

	}
	private Comparator<Integer> maxHeapComparator, minHeapComparator;
	private PriorityQueue<Integer> maxHeap, minHeap;
	public void addNewNumber(int randomNumber) {
		if (maxHeap.size() == minHeap.size()) {
			if ((minHeap.peek() != null) &&randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		}else {
			if(randomNumber < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			}else {
				minHeap.offer(randomNumber);
			}
		}
	}
	public static double getMedian() {
		if (maxHeap.isEmpty()) return minHeap.peek();
		else if (minHeap.isEmpty()) return maxHeap.peek();
		if (maxHeap.size() == minHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else {
			return minHeap.peek();
		}
	}
}
