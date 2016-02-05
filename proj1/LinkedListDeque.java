public class LinkedListDeque<Item> {
  public static void main(String[] args){
    LinkedListDeque<Integer> d = new LinkedListDeque<Integer>();
    System.out.println("Expected: True. Returned: " + d.isEmpty());
    d.addFirst(1);
    d.addFirst(2);
    d.addLast(3);
    d.addLast(4);
    d.printDeque();
    System.out.println("0th item: " + d.get(0));
    System.out.println("1st item" + d.get(1));
    System.out.println("1st item Recursive: " + d.getRecursive(1));
    d.removeFirst();
    d.removeLast();
    System.out.println("Expected: False. Returned: " + d.isEmpty());
    System.out.println("0th item:" + d.get(0));
    System.out.println("0th item Recursive: " + d.getRecursive(0));
    System.out.println("1th item Recursive: " + d.getRecursive(1));
    d.printDeque();
  }
  public class Node{
    public Item item;
    public Node prev;
    public Node next;
      public Node(Item i, Node previous, Node nextNode){
        item = i;
        prev = previous;
        next = nextNode;
      }
  }
  private Node sentinel;
  private int size;

  public LinkedListDeque(){
    size = 0;
    sentinel = new Node(null, sentinel, sentinel);
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
  }
  public void addFirst(Item t){
    Node oldNode = sentinel.next;
    Node newNode = new Node(t, sentinel, oldNode);
    sentinel.next = newNode;
    oldNode.prev = newNode;
    size += 1;
  }
  public void addLast(Item t){
    Node oldNode = sentinel.prev;
    Node newNode = new Node(t, oldNode, sentinel);
    sentinel.prev = newNode;
    oldNode.next = newNode;
    size += 1;
  }
  public boolean isEmpty(){
    if (sentinel.next == sentinel){
      return true;
    }
    return false;
  }
  public int size(){
    return size;
  }

  public void printDeque(){
    Node current = sentinel.next;
    while (current != sentinel){
      System.out.print(current.item + " ");
      current = current.next;
    }
    //System.out.print(current.item);
  }

  public Item removeFirst(){
    if (sentinel.next != sentinel){
      Node NodeRemoved = sentinel.next;
      sentinel.next = NodeRemoved.next;
      NodeRemoved.next.prev = sentinel;
      return NodeRemoved.item;
    }
    return null;
  }

  public Item removeLast(){
    if (sentinel.next != sentinel){
      Node NodeRemoved = sentinel.prev;
      sentinel.prev = NodeRemoved.prev;
      NodeRemoved.prev.next = sentinel;
      return NodeRemoved.item;
    }
    return null;
  }

  public Item get(int index){
    int counter = 0;
    Node current = sentinel.next;
    while(current.next != sentinel){
      if (index == counter){
        return current.item;
      }
      counter += 1;
      current = current.next;
    }
    return null;
  }
  private Item getRecursiveHelper(Node n, int index){
    if (index == 0){
      return n.item;
    }
    else {
      return getRecursiveHelper(n.next, index - 1);
    }
  }
  public Item getRecursive(int index){
    if (index >= size){
      return null;
    }
    else {
      return getRecursiveHelper(sentinel.next, index);
    }
  }
}
