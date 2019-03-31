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

  private boolean addValue(E value){
    if (length == 0){
      start = new Node(value, null, null);
    }else if (length == 1){
      end = new Node(value, null, start);
      start = new Node(start.getData(), end, null);
    }else{
      Node newnode = new Node(value, null, end);
      end.setNext(newnode);
      end = newnode;
    }
    length++;
    return true;
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

  private Node getNthNode(int n){
    Node nth = start;
    for (int i = 0; i < n; i++){
      nth = nth.next();
    }
    return nth;
  }

  public boolean add(E value){
    addIndex(length, value);
    return true;
  }
  
  private void addIndex(int index, E value){
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException();
    }
    if (index == length){
      addValue(value);
    }else if (index == 0){
      Node newnode = new Node(value, start, null);
      start.setPrev(newnode);
      start = newnode;
    }else{
      Node temp = getNthNode(index);
      Node insert = new Node(value, temp, temp.prev());
      temp.prev().setNext(insert);
      temp.setPrev(insert);
    }
    length++;
  }

  private E remove(int index){
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException();
    }
    Node temp = getNthNode(index);
    E returnval;
    if (index == length - 1){
      end.prev().setNext(null);
      returnval = end.getData();
      end = end.prev();
    }else if (index == 0){
      start.next().setPrev(null);
      returnval = start.getData();
      start = start.next();
    }else{
      returnval = temp.getData();
      temp.prev().setNext(temp.next());
      temp.next().setPrev(temp.prev());
    }
    length -= 1;
    return returnval;
  }

  public E removeFront(){
    return remove(0);
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
}
