public class Node{
    private Integer data;
    private Node next, prev;
    public Node(){
        data = 0;
        next = null;
        prev = null;
    }
    public Node(Integer newdata){
        data = newdata;
    }
    public Node(Integer newdata, Node newnext, Node newprev){
        data = newdata;
        next = newnext;
        prev = newprev;
    }
    public Node(Node copy){
        data = copy.getData();
        next = copy.next();
        prev = copy.prev();
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
    public Integer getData(){
        return data;
    }
    public Integer setData(Integer i){
        int temp = data;
        data = i;
        return temp;
    }
    public String toString(){
        return "" + data;
    }
}
