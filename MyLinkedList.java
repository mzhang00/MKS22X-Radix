public class MyLinkedList{
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

  public boolean add(Integer value){
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

  public Integer get(int index){
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException();
    }
    return getNthNode(index).getData();
  }

  public Integer set(int index, Integer value){
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException();
    }
    return getNthNode(index).setData(value);
  }

  public boolean contains(Integer value){
    Node current = start;
    while (current != end){
      if (current.getData().equals(value)){
        return true;
      }
      current = current.next();
    }
    if (current.getData().equals(value)){
      return true;
    }
    return false;
  }

  public int indexOf(Integer value){
    Node current = start;
    int counter = 0;
    while (current != end){
      if (current.getData().equals(value)){
        return counter;
      }
      current = current.next();
      counter++;
    }
    if (current.getData().equals(value)){
      return counter;
    }
    return -1;
  }

  public void add(int index, Integer value){
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException();
    }
    if (index == length){
      add(value);
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

  public Integer remove(int index){
    if (index < 0 || index > length){
      throw new IndexOutOfBoundsException();
    }
    Node temp = getNthNode(index);
    Integer returnval;
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

  public boolean remove(Integer value){
    Node temp = null;
    Node current = start;
    if (start.getData().equals(value)){
      start.next().setPrev(null);
      start = start.next();
      length -= 1;
      return true;
    }
    for (int i = 0; i < length - 1; i++){
      if (current.getData().equals(value)){
        temp = current;
        temp.prev().setNext(temp.next());
        temp.next().setPrev(temp.prev());
        length -= 1;
        return true;
      }
      current = current.next();
    }
    if (end.getData().equals(value)){
      end.prev().setNext(null);
      end = end.prev();
      length -= 1;
      return true;
    }
    return false;
  }

  public void extend(MyLinkedList other){
    if (size() == 0){
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
