import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MultiNumbers {
    public static ArrayList<Long> numList = new ArrayList<>();
    public static ArrayList<Integer> intList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        long num = sc.nextInt();
        long x = getX(num, base);
        System.out.println(x);
    }

    public static long getX(long number, int b){
        //System.out.println(0);
        int[] xArray = getFactors(number, b);
        if(xArray[0] == 0){
            return 0;
        }
        //System.out.println(1);
        /*for (int i = 0; i < xArray.length; i++) {
            System.out.println(xArray[i]);
        }*/
        long xIs = putTogetherNumber(xArray, b);
        //System.out.println(2);
        if((getX(number , b) == (long)0)){
            xIs = getSmallest(numList);
            System.out.println(3);
            return xIs;
        }
        if(xArray[0] != 0 && xIs != 0)
            xIs = getX(number, b);

        return xIs;
    }
    /*public static boolean isSmallest(ArrayList<Long> numList, long currentTry){
        for(long i : numList){
            if(i < currentTry && i != 0){
                return false;
            }
        }
        return true;
    }*/
    public static int[] getFactors(long n, int b){
        System.out.println(n);
        System.out.println(b);
        ArrayList<Integer> factors= new ArrayList<>();
        mainLoop:
        while(n > 1){
            for(int i = b-1; i > 1; i--){
                if(n%i == 0 && (!intList.contains(i) || !factors.isEmpty())){
                    factors.add(i);
                    intList.add(i);
                    System.out.println(i);
                    System.out.println(n);
                    n /= i;
                    break;
                }
                else if(i == 2){
                    System.out.println(9999);
                    factors.clear();
                    break mainLoop;
                }
            }
        }
        if(factors.size() == 0){
            int[] newArray = {0};
            System.out.println(newArray[0]);
            return newArray;
        }
        int u = 0;
        int[] returnArray = new int[factors.size()];
        for(int i : factors){
            returnArray[u] = i;
            u++;
            System.out.println(i);
        }
        return returnArray;
    }
    public static long putTogetherNumber(int[] array, int b){
        long returnLong = 0;
        int pos = array.length - 1;
        Arrays.sort(array);
        for(int i : array){
            System.out.println(i);
            returnLong += (long)i * (Math.pow(b , pos));
            pos--;
        }
        System.out.println(returnLong);
        numList.add(returnLong);
        return returnLong;
    }
    public static long getSmallest(ArrayList<Long> list){
        long smallest = 0;
        boolean firstTime = true;
        for(long i : list) {
            if (firstTime && i != 0) {
                smallest = i;
                firstTime = false;
                System.out.println(10);
            }
            if (i < smallest && i != 0){
                smallest = i;
                System.out.println(i);
            }
        }
        return smallest;
    }

}

