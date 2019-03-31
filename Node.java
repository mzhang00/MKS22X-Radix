public class Node<E>{
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
