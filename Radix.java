import java.util.*;

public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] list = new MyLinkedList[10];
    for (int i = 0; i < list.length; i++){
      list[i] = new MyLinkedList<Integer>();
    }
    int numofdigits = maxDigits(data);
    while (numofdigits != 0){
      for (int i = 0; i < data.length; i++){

      }
      numofdigits--;
      //asd
    }
    /*String[] newdata = new String[data.length];
    for (int i = 0; i < data.length; i++){
      newdata[i] = "" + data[i];
    }*/
    //radixH(newdata, list, numofdigits + 1, 1);
  }

/*
  private static void radixH(String[] data, MyLinkedList<Integer>[] buckets, int maxdigits, int currentdigit){
    if (currentdigit >= maxdigits){
      return;
    }
    for (int i = 0; i < data.length; i++){
      Zint digit = Integer.parseInt(data[i]) % (int)Math.pow(10.0, currentdigit) / (int)Math.pow(10.0, currentdigit - 1);
      if (data[i].charAt(0) == '-'){
        buckets[digit].addFront(Integer.parseInt(data[i]));
      }
    }
  }
*/

  private static int getDigit(int number, int digit){
    return ((number % (int)Math.pow(10.0, digit)) / (int)Math.pow(10.0, digit - 1));
  }

  private static boolean isNegative(int number){
    if (("" + number).charAt(0) == '-'){
      return true;
    }
    return false;
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
    //radixsort(test);
    /*for (String i : ans){
      System.out.println(i);
    }*/
    //System.out.println(386 % 1000 / 100);
    //System.out.println(isNegative(-1));
    System.out.println(getDigit(386, 4));
  }
}