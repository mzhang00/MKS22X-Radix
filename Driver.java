public class Driver{
  public static void main(String[] args){
    MyLinkedList<Integer> myll = new MyLinkedList<>();
    MyLinkedList<Integer> myll2 = new MyLinkedList<>();
    System.out.println(myll);
    myll.addEnd(2);
    myll2.addEnd(3);
    System.out.println(myll);
    System.out.println(myll2);
    myll.extend(myll2);
    System.out.println("odd");
    System.out.println(myll);
  }
}