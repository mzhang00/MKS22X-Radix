public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] list = new MyLinkedList[10];
    int numofdigits = maxDigits(data);
    while (numofdigits > 0){
      
    }
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

  public static void main(String[] args){
    //int[] test = {0,1,123,-1231223, -123};
    //System.out.println(maxDigits(test));
  }
}
