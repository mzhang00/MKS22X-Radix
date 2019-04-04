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

  /*public static void main(String[] args){
    int[] test = {0,-2,6,1,15,3, -123, 234, 23, -22, -12, -2, 13, 19, -1, -1, 13};
    radixsort(test);
    for (int i : test){
      System.out.print(i + " ");
    }
    System.out.println();
    //System.out.println(386 % 1000 / 100);
    //System.out.println(isNegative(-1));
    //System.out.println(getDigit(-386, 2));
  }*/

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Radix.radixsort(data2);
          //Quick.insertionSort(data2, 0, data2.length - 1);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}