
public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity;
    private static int rFactor = 2;

    public ArrayDeque() {
        capacity = items.length;
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst= 0;
        nextLast = 1;
    }

    public void resize(int newCapacity) {
        Item[] newCopy = (Item[]) new Object[newCapacity];
        Item[] temp = (Item[]) new Object[size];
        int position = 0;
        while (position < size){
            temp[position] = (items[(nextFirst + 1 + position) % items.length]);
            position++;
        }
        
        System.arraycopy(temp, 0, newCopy, 0, size);
        items = newCopy;
        nextFirst = items.length - 1;
        nextLast = size;

    }

    public boolean downsize() {
        if ((size / items.length) < 0.25) {
            return true;
        }
        else {
            return false;
        }
    }


    public void addFirst(Item x) {
        // adds an item to the front
        if (size == items.length) {
            resize(size * rFactor);
        }

        items[nextFirst] = x;
        if (nextFirst == 0) {
            nextFirst = nextFirst - 1 + capacity; // loop around
        }
        else {
            nextFirst--;
        }
    	size++;
    }

    public void addLast(Item x) {
    	// adds an item to the back
        if (size == items.length) {
            resize(size * rFactor);
        }
        
        items[nextLast] = x;
        if (nextLast == capacity - 1) {
            nextLast = 0;
        }
        else {
            nextLast++;
        }
        size++;
    }

    public boolean isEmpty() {
    	// returns true if deque is empty
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
    	// returns num items in deque
        return size;
    }

    public void printDeque() {
    	// prints items from first to last separated by spaces
        if (isEmpty()) {
            System.out.println(); // empty, nothing in deque
        }
        else {
            int position = 0;
            while (position < size) {
                System.out.print(items[(nextFirst + 1 + position) % items.length] + " ");
                position++; 
            }
        }   
  }


    public Item removeFirst() {
    	// removes and returns item at front
        int removeFirstTrack;
        Item itemToRemove;
        if (nextFirst == capacity - 1) {
            removeFirstTrack = 0;
        }
        else {
            removeFirstTrack = nextFirst + 1;
        }
        
        if (removeFirstTrack == 0) {
            itemToRemove = items[removeFirstTrack];
            items[removeFirstTrack] = null;
            nextFirst = 0; // very front is empty
            size--;
            if (downsize()) {
                resize(size / rFactor);
            }
        }
        else {
            itemToRemove = items[removeFirstTrack];
            items[removeFirstTrack] = null;
            nextFirst++;
            size--;
            if (downsize()) {
                resize(size / rFactor);
            }

        }
        return itemToRemove;
    }

    public Item removeLast() {
    	// removes and returns item at back
        int removeLastTrack;
        Item itemToRemove;
        if (nextLast == 0) {
            removeLastTrack = capacity - 1;
        }
        else {
            removeLastTrack = nextLast - 1;
        }
       
        if (removeLastTrack == capacity - 1) {
            itemToRemove = items[removeLastTrack];
            items[removeLastTrack] = null;
            nextLast = capacity - 1;
            size--;
            if (downsize()) {
                resize(size / rFactor);
            }
        }
        else {
            itemToRemove = items[removeLastTrack];
            items[removeLastTrack] = null;
            nextLast--;
            size--;
            if (downsize()) {
                resize(size / rFactor);
            }
        }
        return itemToRemove;
    }

    public Item get(int index){
        if (index < size){
            return items[(nextFirst + 1 + index) % items.length];
        }
        else {
            return null;
        }
  }
}



    /*private static void main (String[] args) {
        ArrayDeque testArray = new ArrayDeque();
        testArray.addFirst(0);
        testArray.addFirst(7);
        testArray.addLast(1);
        testArray.printDeque(); // 7 0 1
        System.out.println();
        System.out.println(testArray.get(2)); // 1
        System.out.println(testArray.removeFirst()); // 7
        System.out.println(testArray.removeLast()); // 1 
        testArray.printDeque(); // 0
        System.out.println();
        System.out.println(testArray.size()); // 1
        System.out.println(testArray.isEmpty()); // false
        testArray.addFirst("second");
        testArray.addFirst("first");
        testArray.addLast(1);
        testArray.addLast(2);
        testArray.addLast(3);
        testArray.printDeque(); // first second 0 1 2 3
        System.out.println();
        System.out.println(testArray.size());
        testArray.addLast(4);
        testArray.addLast(5);
        testArray.addFirst(6);
        testArray.printDeque();*/
    

