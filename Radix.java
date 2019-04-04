import java.util.*;

public class Radix{
  public static void radixsort(int[] data){

    if (data.length <= 1){
      return;
    }

    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[19];
    
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    
    int numofdigits = maxDigits(data);
    int currentdigit = 1;
    
    while (currentdigit <= numofdigits){
      for (int i = 0; i < data.length; i++){
        int digit = getDigit(data[i], currentdigit);
        if (isNegative(digit)){
          buckets[digit + 9].addFront(data[i]);
        }else{
          buckets[digit + 9].addEnd(data[i]);
        }
        
      }
      int counter = 0;
      for (int i = 0; i <= 18; i++){
        while(buckets[i].size() > 0){
          data[counter] = buckets[i].removeFront();
          counter++; 
        }
      }
      currentdigit++;
    }
  }

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
    int[] test = {0,-2,6,1,15,3, -123, 234, 23, -22, -12, -2, 13, 19};
    radixsort(test);
    for (int i : test){
      System.out.print(i + " ");
    }
    System.out.println();
    //System.out.println(386 % 1000 / 100);
    //System.out.println(isNegative(-1));
    //System.out.println(getDigit(-386, 2));
  }
}