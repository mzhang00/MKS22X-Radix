public class MyLinkedList<E>{
  private int length;
  private Node start,end;

  public MyLinkedList(){
    length = 0;
    start = null;
    end = null;
  }

  public void clear(){
    length = 0;
    start = null;
    end = null;
  }

  public int size(){
    return length;
  }

  public String toString(){
    if (length == 0){
      return "[]";
    }
    Node current = start.next();
    String returnval = "[" + start + ", ";
    while (current != null){
      returnval = returnval + current.getData() + ", ";
      current = current.next();
    }
    return returnval.substring(0, returnval.length() - 2) + "]";
  }

  public boolean addFront(E value){
    if (length == 0){
      start = new Node(value, start, null);
      end = start;
    }else{
      Node temp = new Node(value, start, null);
      start.setPrev(temp);
      start = temp;
    }
    length++;
    return true;
  }

  public boolean addEnd(E value){
    if (length == 0){
      end = new Node(value, null, end);
      start = end;
    }else{
      Node temp = new Node(value, null, end);
      end.setNext(temp);
      end = temp;
    }
    length++;
    return true;
  }

  public E removeFront(){
    E returnval = start.getData();
    if (length == 1){
      clear();
    }else{
      start.next().setPrev(null);
      start = start.next();
      length--; 
    }
    return returnval;
  }

  public void extend(MyLinkedList<E> other){
    if (this.size() == 0){
      start = other.start;
      end = other.end;
      length = other.length;
      other.start = null;
      other.end = null;
      other.length = 0;
    }else if (other.size() != 0){
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
      length += other.size();
      other.start = null;
      other.end = null;
      other.length = 0;
    }
  }

  class Node{
    private E data;
    private Node next, prev;

    public Node(){
      data = null;
      next = null;
      prev = null;
    }

    public Node(E newdata){
      data = newdata;
      next = null;
      prev = null;
    }

    public Node(E newdata, Node newnext, Node newprev){
      data = newdata;
      next = newnext;
      prev = newprev;
    }

    public Node next(){
      return next;
    }

    public Node prev(){
      return prev;
    }

    public void setNext(Node other){
      next = other;
    }

    public void setPrev(Node other){
      prev = other;
    }

    public E getData(){
      return data;
    }

    public E setData(E i){
      E temp = data;
      data = i;
      return temp;
    }

    public String toString(){
      return data.toString();
    }
  }
}
