public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] list = new MyLinkedList[10];
    int numofdigits = maxDigits(data);
    return;
  }

  private static int maxDigits(int[] data){
    int max = 0;
    for (int i = 0; i < data.length; i++){
      String temp = ("" + data[i]);
      if (temp.charAt(0) != '-' && temp.length() > max){
        max = ("" + data[i]).length();
      }else{
        if (temp.charAt(0) == '-' && temp.length() - 1 > max){
          max = ("" + data[i]).length() - 1;
        }
      }
    }
    return max;
  }
}
