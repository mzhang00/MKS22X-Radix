import java.util.*;

public class Radix{
  public static void radixsort(int[] data){

    if (data.length <= 1){
      return;
    }

    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    
    int numofdigits = maxDigits(data);
    int currentdigit = 1;
    
    MyLinkedList<Integer> helperlist = new MyLinkedList<>();
    
    /*for (int i = 0; i < data.length; i++){
      if (isNegative(data[i])){
        buckets[(getDigit(data[i], currentdigit)) * -1].addFront(data[i]);
      }else{
        buckets[getDigit(data[i], currentdigit)].addEnd(data[i]);
      }
    }

    if (currentdigit != numofdigits){ 
      for (int i = 0; i < data.length; i++){
        helperlist.extend(buckets[i]);
        buckets[i].clear();
      }
    }else{
      for (int i = 0; i < data.length; i++){
        helperlist.extend(buckets[i]);
        buckets[i].clear();
      }
      //sortEnd();
      //return;
    }
    currentdigit--;*/

    while (currentdigit <= numofdigits){
      while (helperlist.size() > 0){
        int temp = helperlist.removeFront();
        if (isNegative(temp)){
          buckets[getDigit(temp, currentdigit)].addFront(temp);
        }else{
          buckets[getDigit(temp, currentdigit)].addEnd(temp);
        }
      }
      if (currentdigit != numofdigits){ 
        for (int i = 0; i < data.length; i++){
          helperlist.extend(buckets[i]);
          buckets[i].clear();
        }
      }else{
        for (int i = 0; i < data.length; i++){
          helperlist.extend(buckets[i]);
          buckets[i].clear();
        }
        //sortEnd();
        //return;
      }
      currentdigit--;
    }
  }

  private static void sortEnd(){
    return;
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
    int[] test = {0,1,123,1231223, 1123};
    radixsort(test);
    for (int i : test){
      System.out.println(i);
    }
    //System.out.println(386 % 1000 / 100);
    //System.out.println(isNegative(-1));
    //System.out.println(getDigit(-386, 2));
  }
}