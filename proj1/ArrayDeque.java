public class ArrayDeque<Item>{

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int rFactor = 2;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int newCapacity) {
        Item[] newCopy = (Item[]) new Object[newCapacity];
        int position = 0;
        while (position < size) {
            newCopy[position] = (items[(nextFirst + 1 + position) % items.length]);
            position++;
        }
        nextFirst = newCopy.length - 1;
        nextLast = size;
        items = newCopy;
    }

    private boolean downsize() {
        if ((size * 4) < items.length && items.length > 16) {
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
            nextFirst = nextFirst - 1 + items.length; // loop around
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
        if (nextLast == items.length - 1) {
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
        Item itemToRemove;
        if (downsize()) {
            resize(items.length / rFactor);
        }
        if (size == 0) {
            return null;
        }
        else if (nextFirst == items.length - 1) {
            itemToRemove = items[0];
            items[0] = null;
            nextFirst = 0;
        }
        else {
            itemToRemove = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst++;
        }
        size --;
        return itemToRemove;
    }
    


    public Item removeLast() {
    	// removes and returns item at back
        Item itemToRemove;
        if (downsize()) {
            resize(items.length / rFactor);
        }
        if (size == 0) {
            return null;
        }
        else if (nextLast == 0) {
            itemToRemove = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        }
        else {
            itemToRemove = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast--;
        }
        size --;
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

