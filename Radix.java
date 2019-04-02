public class Radix{
  public static String[] radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] list = new MyLinkedList[10];
    int numofdigits = maxDigits(data);
    String[] newdata = new String[data.length];
    for (int i = 0; i < data.length; i++){
      newdata[i] = "" + data[i];
    }
    return newdata;
    //radixH(data, list, numofdigits);
  }

  private static void radixH(int[] data, MyLinkedList<Integer>[] buckets, int digits){
    if (digits == 0){
      return;
    }
    for (int i = 0; i < data.length; i++){
      return;
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
    int[] test = {0,1,123,-1231223, -123};
    String[] ans = radixsort(test);
    for (String i : ans){
      System.out.println(i);
    }
  }
}
