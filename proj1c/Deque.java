public interface Deque<Item> {
	public void addFirst(Item x);
	public void addLast(Item x);
	public Item removeFirst();
	public Item removeLast();
	public Item get(int index);
	public boolean isEmpty();
	public void printDeque();
	public int size();
}