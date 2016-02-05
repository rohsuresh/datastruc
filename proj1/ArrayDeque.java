public class ArrayDeque<Item>{
  public static void main(String[] args) {
      ArrayDeque<Integer> d = new ArrayDeque<Integer>();
      //d.removeFirst();
      //d.removeLast();
      //d.printDeque();
      /*d.addFirst(5);
      d.addFirst(4);
      d.addLast(1);
      d.addFirst(3);
      d.addFirst(2);
      //d.printDeque();
      System.out.println(d.get(0));
      System.out.println(d.get(1));
      System.out.println(d.get(3));
      System.out.println(d.get(5));
      d.removeFirst();
      d.removeFirst();
      d.removeLast();
      System.out.println(d.get(0));*/
      /*d.addLast(0);
      d.addLast(1);
      d.addLast(2);
      d.addLast(3);
      d.addLast(4);
      d.addLast(5);
      d.addLast(6);
      System.out.print(d.isEmpty());
      d.addLast(8);
      d.addLast(9);
      d.addLast(10);
      d.printDeque();
      d.removeFirst(); */
      d.addFirst(1);
      //d.addFirst(2);
      d.addLast(3);
      d.addLast(4);
      d.addLast(5);
      d.addLast(6);
      d.addLast(8);
      d.addLast(9);
      d.addLast(10);
      d.addLast(11);
      d.printDeque();

   }
  private Item[] items;
  private int size;
  private int nextFirst;
  private int nextLast;
  private static int RFactor = 2;
  public ArrayDeque(){
    items = (Item[]) new Object[8];
    size = 0;
    nextFirst = 0;
    nextLast = 1;
  }
  public void addFirst(Item t){
    if (size != items.length){
      items[nextFirst] = t;
      size = size + 1;
      nextFirst = (((nextFirst - 1) % items.length) + items.length) % items.length; //From Stack Overflow
    }
    else{
      resize(size * RFactor);
      items[nextFirst] = t;
      size = size + 1;
      nextFirst = (((nextFirst - 1) % items.length) + items.length) % items.length;
    }
  }
  public void addLast(Item t){
    if (size != items.length){
      items[nextLast] = t;
      size = size + 1;
      nextLast = (nextLast + 1) % items.length;
    }
    else{
      resize(size * RFactor);
      items[nextLast] = t;
      size = size + 1;
      nextLast = (nextLast + 1) % items.length;
    }
  }
  public void resize(int capacity){
    Item[] a = (Item[]) new Object[capacity];
    Item[] temp = (Item[]) new Object[size];
    int index = 0;
    while (index < size){
       temp[index] = (items[(nextFirst + 1 + index) % items.length]);
       index = index + 1;
    }
    System.arraycopy(temp, 0, a, 0, size);
    nextFirst = capacity - 1;
    nextLast = size;
    items = a;
  }

  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    return false;
  }
  public int size(){
    return size;
  }
  public void printDeque(){
    int index = 0;
    while (index < size){
      System.out.println(items[(nextFirst + 1 + index) % items.length]);
       index = index + 1;
    }
  }
  private double usage(){
    return size/items.length;
  }
  public Item removeFirst(){
    if (this.isEmpty()){
      return null;
    }
    else {
      Item itemToReturn = items[(nextFirst + 1) % items.length];
      size = size - 1;
      items[(nextFirst + 1) % items.length] = null;
      nextFirst = (nextFirst + 1) % items.length;
      return itemToReturn;
    }
    }
  public Item removeLast(){
    if (this.isEmpty()){
      return null;
    }
    else {
      Item itemToReturn = items[(((nextLast - 1) % items.length) + items.length) % items.length];
      size = size - 1;
      items[(((nextLast - 1) % items.length) + items.length) % items.length] = null;
      nextLast = (((nextLast - 1) % items.length) + items.length) % items.length;
      return itemToReturn;
    }
  }
  public Item get(int index){
    if (index < size){
      return items[(nextFirst + 1 + index) % items.length];
    }
    else{
      return null;
    }
  }
}
