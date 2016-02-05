public class LinkedListDeque<Item> {

	
	public class Node {
		public Node prev;
        public Item item;
		public Node next;

		public Node (Node p, Item x, Node n) {
			// parameters: Node, previous Node, next Node
			prev = p;
            item = x;
			next = n;
		}
	}

	private Node sentinel;
	private int size;
	
	public LinkedListDeque() {
		// empty linked list deque
		size = 0;
		sentinel = new Node(sentinel, null, sentinel);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
		// in an empty list previous and next are sentinel itself
	}

    public void addFirst(Item x) {
    	// adds an Node to the front
    	// no recursion or iteration
    	Node oldFirstNode = sentinel.next;
    	Node newFirstNode = new Node(sentinel, x, oldFirstNode);
    	oldFirstNode.prev = newFirstNode;
        sentinel.next = newFirstNode;
    	size += 1;
    }

    public void addLast(Item x) {
    	// adds an Node to the back
    	// no recursion or iteration
    	Node oldLastNode = sentinel.prev;
    	Node newLastNode = new Node(oldLastNode, x, sentinel);
        oldLastNode.next = newLastNode;
        sentinel.prev = newLastNode;
        size += 1;    	
    }

    public boolean isEmpty() {
    	// returns true if deque is empty
        if (sentinel.next == sentinel) {
            // only sentinel is present and in circular strcuture
            size = 0;
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
    	// returns num Nodes in deque
    	// constant time
        return size;
    }

    public void printDeque() {
    	// prints items from first to last separated by spaces
        int counter = 0;
        Node nodeToPrint = sentinel.next;
        while (counter < size) {
            System.out.print(nodeToPrint.item + " ");
            nodeToPrint = nodeToPrint.next;
            counter += 1;
        }
    }

    public Item removeFirst() {
    	// removes and returns Node at front
    	// no recursion or iteration
        
        Node nodeToBeRemoved = sentinel.next;
        sentinel.next = nodeToBeRemoved.next;
        nodeToBeRemoved.next.prev = sentinel;
        // now no references pointing to the Node
        
        size = size - 1;
        return nodeToBeRemoved.item;
    }

    public Item removeLast() {
    	// removes and returns Node at back
    	// no recursion or iteration
        
        Node nodeToBeRemoved = sentinel.prev;
        sentinel.prev = nodeToBeRemoved.prev;
        nodeToBeRemoved.prev.next = sentinel;
        // now no reference pointing to the Node
        
        size = size - 1;
        return nodeToBeRemoved.item;
    }

    public Item get(int index) {
    	// gets Node at given index, doesn't change the linked list
    	// use iteration
        if (index >= size) {
            return null;
        }
        
        int counter = 0;
        Node nodeToGet = sentinel.next;
        while (counter < index) {
            nodeToGet = nodeToGet.next;
            counter += 1;
        }
        return nodeToGet.item;
    }

    public Item getRecursive(int index) {
		// recursive get method
        if (index >= size) {
            return null;
        }
        
        return getRecursiveHelper(index, sentinel.next);
	}

    private Item getRecursiveHelper(int index, Node position) {
        if (index == 0) {
            return position.item;
        }
        else {
            return getRecursiveHelper(index - 1, position.next);
        }
    }
}


    /*public static void main (String[] args) {
        LinkedListDeque testLink = new LinkedListDeque();
        // series of methods run for testing
        testLink.addFirst(2);
        testLink.addFirst(1);
        testLink.addLast(3);
        testLink.addLast(4);
        testLink.printDeque();
        System.out.println();
        System.out.println(testLink.get(2)); // should retrieve the integer 3
        System.out.println(testLink.getRecursive(3)); // should retrieve the integer 4
        System.out.println(testLink.size()); // should be 4
        System.out.println(testLink.removeLast()); // should be 4
        System.out.println(testLink.removeFirst()); // should be 1
        System.out.println(testLink.size()); // should be 2
        testLink.printDeque();
        System.out.println();
        System.out.println(testLink.get(4)); // should be null
        System.out.println(testLink.getRecursive(5)); // should be null
        System.out.println(testLink.isEmpty()); // should be false

        
    }*/
